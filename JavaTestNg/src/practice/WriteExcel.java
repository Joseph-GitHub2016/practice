package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WriteExcel {
	File fl;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sh;
	Map<Object, Object> tm;
	int rc;
	
	
	@DataProvider(name="testData")
	public Object[][] readWrite()
	{
		fl = new File("c://Automation Script datatable.xlsx");
	
		try {
			 fis = new FileInputStream(fl);
		} catch (FileNotFoundException e) {
			System.out.println("file not found exception");
		}
		try {
			 wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 sh = wb.getSheet("Global");
	
	 
	 rc= sh.getPhysicalNumberOfRows();
	System.out.println("row count - "+rc);
	int cc = sh.getRow(0).getPhysicalNumberOfCells();
	System.out.println("column count - "+cc);
	int x = 0;
	Object[][] obj = new Object[rc-1][1];
	for(int i =1;i<rc;i++)
	{
		tm = new HashMap<Object, Object>();
		for(int j=0;j<cc;j++)
		{
			Object key = sh.getRow(0).getCell(j).getStringCellValue();
			Object value = sh.getRow(i).getCell(j).getStringCellValue();
			tm.put(key, value);		
		}
		obj[x][0] = tm;
		x++;
	}
	return obj;
	}
	
	@Test(dataProvider="testData")
	public void getData(Map<Object, Object> t)
	{
		int i = 0;
			Object name = t.get("Last_Name");
			System.out.println(name);
			try {
				fos= new FileOutputStream(fl);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			wb.getSheet("Global").getRow(i).createCell(24).setCellValue("pass");
			try {
				wb.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		i++;	
	}

}

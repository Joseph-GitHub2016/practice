package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class PasswordTest {
	WebDriver driver;
	 @Test
	    public void test()
	    {
			System.setProperty("webdriver.chrome.driver","C:/DriverServer/chromedriver.exe");
			driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://docs.sencha.com/extjs/4.2.1/extjs-build/examples/form/adv-vtypes.html");
	        WebElement username=driver.findElement(By.id("textfield-1014-inputEl"));
	        username.sendKeys("admin");
	        System.out.println(username.getText());
	        WebElement password=driver.findElement(By.id("textfield-1015-inputEl"));
	        password.sendKeys("admin");
	        System.out.println(password.getAttribute("textContent"));
	        //WebElement login=driver.findElement(By.id("login"));
	    }

}

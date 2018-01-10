package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


public class Testbase {

	
	public static WebDriver driver;
	public Properties prop;

	public WebDriver DriverInitialize() throws IOException
{
	
 prop= new Properties();
 FileInputStream file=new FileInputStream("C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\resources\\data.properties");
 
 prop.load(file);
 String browserName=prop.getProperty("browser");
 System.out.println(browserName);
 
 if(browserName.equals("chrome"))
 {
 	// System.setProperty("webdriver.chrome.driver", 
	 //"C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\ecommerce\\Drivers\\chromedriver.exe");
 	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocn"));
 	driver= new ChromeDriver();
 		//execute in chrome driver
 	
 }
 else if (browserName.equals("firefox"))
 {
	 driver = new FirefoxDriver();
 }
 else if (browserName.equals("IE"))
 {
// 	IE code
 }
 return driver;
}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		StringBuilder screenShtLocn=new StringBuilder();
		screenShtLocn.append("C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\ecommerce\\screenshots\\");
		screenShtLocn.append(result);
		screenShtLocn.append("error.png");
		File screenShotName = new File(screenShtLocn.toString());
		FileUtils.copyFile(src, screenShotName);
		
	}
	
	//Method can be called by all child classes to create their respective element for their xpaths
	public WebElement returnWebElForXpath(By elementXpth)
	{
		
		return driver.findElement(elementXpth);
	}
	//Method can be called by all child classes expecting a list of elements for operations suh as search
	public List<WebElement> returnListForXpath(By elementXpth)
	{
		
		return driver.findElements(elementXpth);
	}
}

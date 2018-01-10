package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Testbase;
import utility.ReadExcel;

public class SignInpage extends Testbase{
	By cntasgst = By.xpath(ReadExcel.getXpath("a20"));
	

	public WebElement cntasgst()
	{
		
		return returnWebElForXpath(cntasgst);
	}
	
	
	
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Testbase;
import utility.ReadExcel;

public class GuestCheckout extends Testbase{
	ReadExcel rd = new ReadExcel();
	
	By Done = By.xpath(rd.getXpath("a21"));

	


	public WebElement done()
	{
		
		return returnWebElForXpath(Done);
	}
	
	
}

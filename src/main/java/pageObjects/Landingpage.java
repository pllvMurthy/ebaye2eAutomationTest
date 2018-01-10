package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Testbase;
import utility.ReadExcel;

public class Landingpage extends Testbase{
	ReadExcel rd = new ReadExcel();
	By search = By.xpath(rd.getXpath("a1"));
	By searchbtn = By.xpath(rd.getXpath("a2"));

	public WebElement search()
	{
		
		return returnWebElForXpath(search);
	}
	
	public WebElement searchbtn()
	{
		
		return returnWebElForXpath(searchbtn);
	}
	
}

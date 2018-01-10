package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Testbase;
import utility.ReadExcel;

public class Searchpage extends Testbase{


	ReadExcel rd = new ReadExcel();
	By search = By.xpath(rd.getXpath("a1"));
	By searchbtn = By.xpath(rd.getXpath("a2"));
	By searchresult = By.xpath(rd.getXpath("a3"));
	By completeSearchResult = By.xpath(rd.getXpath("a4"));
	By screensizeselect = By.linkText(rd.getXpath("a5"));
	By screensizeselectresults = By.xpath(rd.getXpath("a6"));
	

	public WebElement searchresultrel()
	{
		
		return returnWebElForXpath(searchresult);
	}
	
	public List<WebElement> completeSearchResult()
	{
		
		return returnListForXpath(completeSearchResult);
	}
	public WebElement screensizeselect()
	{
		
		return driver.findElement(screensizeselect);
	}
	public List<WebElement> screensizeselectresults()
	{
		
		return returnListForXpath(screensizeselectresults);
	}
}

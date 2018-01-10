package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Testbase;
import utility.ReadExcel;

public class ProductDetails extends Testbase{
	ReadExcel rd = new ReadExcel();
	By Itemcondition = By.xpath(rd.getXpath("a7"));
	By timelft = By.xpath(rd.getXpath("a8"));
	By price = By.xpath(rd.getXpath("a9"));
	By itemname = By.xpath(rd.getXpath("a10"));
	By sellername = By.xpath(rd.getXpath("a11"));
	
	By addtocart = By.xpath(rd.getXpath("a12"));
	
	public WebElement Itemcondition()
	{
		
		return returnWebElForXpath(Itemcondition);
	}
	
	public WebElement timelft()
	{
		
		return returnWebElForXpath(timelft);
	}
	public WebElement price()
	{
		
		return returnWebElForXpath(price);
	}
	public WebElement itemname()
	{
		
		return returnWebElForXpath(itemname);
	}
	public WebElement sellername()
	{
		
		return returnWebElForXpath(sellername);
	}
	public WebElement addtocart()
	{
		
		return returnWebElForXpath(addtocart);
	}
	
	}

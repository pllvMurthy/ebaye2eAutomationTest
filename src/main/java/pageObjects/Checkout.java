package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Testbase;
import utility.ReadExcel;

public class Checkout extends Testbase{

	By shopcartlabel = By.xpath(ReadExcel.getXpath("a13"));
	By scsellername = By.xpath(ReadExcel.getXpath("a14"));
	By scproductname = By.xpath(ReadExcel.getXpath("a15"));
	By scprice = By.xpath(ReadExcel.getXpath("a16"));
	By total = By.xpath(ReadExcel.getXpath("a17"));
	By unitprice = By.xpath(ReadExcel.getXpath("a19"));
	By checkout = By.xpath(ReadExcel.getXpath("a18"));
	

	public WebElement shopcartlabel()
	{
		
		return returnWebElForXpath(shopcartlabel);
	}
	public WebElement scsellername()
	{
		
		return returnWebElForXpath(scsellername);
	}
	public WebElement scproductname()
	{
		
		return returnWebElForXpath(scproductname);
	}
	public WebElement scprice()
	{
		
		return returnWebElForXpath(scprice);
	}
	public WebElement total()
	{
		
		return returnWebElForXpath(total);
	}
	public WebElement unitprice()
	{
		
		return returnWebElForXpath(unitprice);
	}
	public WebElement checkout()
	{
		
		return returnWebElForXpath(checkout);
	}
	}

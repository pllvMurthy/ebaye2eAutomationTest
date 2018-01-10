package ecommerce;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Checkout;
import pageObjects.Landingpage;
import pageObjects.ProductDetails;
import pageObjects.Searchpage;
import pageObjects.SignInpage;
import resources.Testbase;
import utility.ReadExcel;
import pageObjects.GuestCheckout;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

public class E2ETest extends Testbase{
	Testbase b=new Testbase();
	ReadExcel rd = new ReadExcel();
	private static final Logger logger = Logger.getLogger(E2ETest.class);
	  public Object[][] data = new Object[1][3];
	@BeforeTest
	public void initialize() throws IOException
	{
		DOMConfigurator.configure("C:\\Users\\Pallavi\\ebay-e2e\\src\\main\\java\\resources\\log4j.xml");
		 driver =DriverInitialize();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
		 logger.info("URL launched");
	}
	
	@Test(priority=1)
	public void landingpagenavigation()
	{
	String title = driver.getTitle();
	if (title.equals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay"))
	{
		logger.info("User is on landing page. Navigation to Home Page successful.");
	}
	else
		logger.info("Navigation to Hoem Page failed.");
	
	}
	
	@Test(priority=2)
	public void searchnavigation() throws IOException
	{

		Landingpage lp=new Landingpage();
		lp.search().click();
		lp.search().sendKeys(ReadExcel.getKeys("search"));
		logger.info("Read the sony tv keyword from excel");
		lp.searchbtn().click();
	}
	
	@Test(priority=3)
	public void searchpage()
	{
		Searchpage sp=new Searchpage();
		String searchtext =sp.searchresultrel().getText();
		if (searchtext.equals("results for sony tv"))
		{
			logger.info("list of related products are shown");
		}
		else
			logger.info("Irrelevant search");
		}

	@Test(priority=4)
	public void searchresults()
	{
		Searchpage sp=new Searchpage();
		List<WebElement>results = sp.completeSearchResult();
		int a = results.size();
		logger.info("All Listing Search Results displayed =" + a);
		    // Loop over the list to verify each result link contains sony and tv
		    for (int i = 0; i < results.size(); i++) {
		        Assert.assertTrue(results.get(i).getText().contains("sony"), "Search result validation failed at instance" + i+results.get(i).getText());
		    }
		    for (int i = 0; i < results.size(); i++) {
		        Assert.assertTrue(results.get(i).getText().contains("tv"), "Search result validation failed at instance" + i + results.get(i).getText());
		    }
	}
	
	@Test(priority=5)
	public void searchresultsscreensize()
	{
		Searchpage sp=new Searchpage();
		List<WebElement>results = sp.completeSearchResult();
		int a = results.size();
		sp.screensizeselect().click();
		List<WebElement>results2 = sp.screensizeselectresults();
		int b = results2.size();
		logger.info("Search Results displayed for screen size 50-60 inch =" + b);
	
	   if (b != a && b<a)
	   {
		   logger.info("New list is displayed");
		  
	   }
	   else if (b == a)
	   {
		   logger.info("Search List did not change. Same list is displayed which means either the search with screen size failed or all TVs displayed currently are (50-60 inch.");
	   }
	}
	
	@Test(priority=6)
	public void testselectrandomproduct()throws NoSuchElementException
	{
		Searchpage sp=new Searchpage();
		List<WebElement>results2 = sp.screensizeselectresults();
	   Random rand = new Random();
	    WebElement randomElement = results2.get(rand.nextInt(results2.size()));
	   String Product = randomElement.getAttribute("Id");
	   logger.info("Random Product Selected: " + Product);
	   StringBuilder linkxpath=new StringBuilder();
	   linkxpath.append(rd.getXpath("a22"));
	   linkxpath.append(Product);
	   linkxpath.append(rd.getXpath("a23"));
	   String linkxPth=linkxpath.toString();
	   driver.findElement(By.xpath(linkxPth)).click();
	   ProductDetails pd = new ProductDetails();
	  if (pd.Itemcondition().isDisplayed())
	  {
		  System.out.println("User is on Product Details page");
		  pd.Itemcondition().getText();
		  System.out.println("Item condition is: " + pd.Itemcondition().getText());
	  }
	  try {
		  
	  if (pd.timelft().isDisplayed())
	  {
		  String time = pd.timelft().getText();
		  if (time.matches("\\d{4}-\\d{2}-\\d{2}")) {
			  System.out.println("Time left is: " + time);
			}
	  }
	
	  else if (pd.timelft().isDisplayed() == false) {
		  System.out.println("Time Left is not displayed.");
	  }
	  }
	  catch (NoSuchElementException e) {
		  System.out.println("Time Left is not displayed.");
	  }
	  if (pd.price().isDisplayed())
	  {
		  String price = pd.price().getText();
	  }
		  
	}
	
	
	
	@Test(priority=7)
	public void addTocart()
	{
		ProductDetails pd = new ProductDetails();
		data[0][0] = pd.sellername().getText();
		data[0][1] = pd.itemname().getText();
		data[0][2] = pd.price().getText();
		pd.addtocart().click();
	}
	
	@Test(priority=8)
	public void checkout()
	{
		Checkout co = new Checkout();
		
		if(co.shopcartlabel().isDisplayed())
		{	
			if (co.shopcartlabel().getText().equals("Your eBay Shopping Cart"))
				{
				logger.info("User is on the Shopping cart page");
		}
		}
		
		Object[][] codata = new Object[1][3];
		codata = data;
		if(codata[0][0].equals(co.scsellername().getText())) {
			logger.info("Seller Name matches.");
		}else{
			logger.info("Seller Name doesn't match.");
		}
		if(codata[0][2].equals(co.scprice().getText())) {
			logger.info("Price matches.");
		}else{
			logger.info("Price doesn't match.");
		}
		if(codata[0][1].equals(co.scproductname().getText())) {
			logger.info("Product Name matches.");
		}else{
			logger.info("Product Name doesn't match.");
		}
		if(co.total().getText().equals(co.unitprice().getText()))
		{
			logger.info("Total price same as unit price. Proceed to checkout");
			co.checkout().click();
		}
		else
		{
			logger.warn("check the items in the cart");
		}
		
	}
	@Test(priority=9)
	public void cntasguest()
	{
		SignInpage sip = new SignInpage();
		if(sip.cntasgst().isDisplayed()) {
		sip.cntasgst().click();
		GuestCheckout gco = new GuestCheckout();
		gco.done();
		}
		else
		{
			logger.info("Continue as guest option is not displayed.");
		}
	}
	
	@AfterMethod
	public void onTestFailure(ITestResult result) throws IOException {
		
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				
			b.getScreenshot(result.getName());
			}
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	
		
	}
	


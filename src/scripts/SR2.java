package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;


public class SR2 {
	WebDriver driver ;
	WrapperMethods wm ;
	
  @Test
  public void verifyMobileCost() {
	  
	  wm.compareTitleString(Util.home_title);
	  wm.clickValueByXpathAttr("nav","id", "\"nav\"","/ol/li/a");
	  wm.compareTitleString("Mobile");
	  wm.selectDropdownByXpathandVisibleText("select", "title", "\"Sort By\"", "Name");
	  String price1 = wm.getTextBySelectValueByXpath("span", "id", "\"product-price-1\"","/span");
	  System.out.println(price1);
	  
	  wm.clickById("product-collection-image-1");
	  String price2 = wm.getValueById("product-price-1");
	  System.out.println(price2);
	  if(price1.equals(price2))
	  {
		  System.out.println("pass");
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
		wm = new WrapperMethods(driver);
	  wm.getUrl(Util.url);
  }

  @AfterMethod
  public void afterMethod() {
	  wm.exitBrowser();
  }

}

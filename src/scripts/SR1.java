package scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR1 {
	WebDriver driver;
	WrapperMethods wm;
	
  @Test
  public void verifyMobileList() {

	  wm.compareTitleString(Util.home_title);
	  wm.clickValueByXpathAttr("nav", "id","\"nav\"","/ol/li/a");
	  wm.compareTitleString("Mobile");
	  wm.selectDropdownByXpathandVisibleText("select", "title", "\"Sort By\"", "Name");
	  List<WebElement> ele = wm.selectElementsByClassName("product-image");  
	  String[] txt  = wm.storeWebElemetsByAttributeValueInStringArray(ele,"title"); 
	  wm.checkStringArraySorted(txt);	
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

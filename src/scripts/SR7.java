package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR7 {
	WebDriver driver;
	WrapperMethods wm ;
	
  @Test
  public void saveOrderAsPDF() {
	  
	  wm.clickValueByXpathAttrOnly("a", "class", "\"skip-link skip-account\"");
		wm.clickValueByLinkText("My Account");
		wm.setValueById("email", "test1234@gmail.com");
		wm.setValueById("pass", "test1234");
		wm.clickById("send2");

		System.out.println(wm.getTextBySelectValueByXpath("table", "id","\"my-orders-table\"", "/tbody/tr/td[5]/em"));
		
		//wm.clickValueByLinkTextAndIndex("My Orders", 1);
		wm.clickValueByLinkText("VIEW ORDER");
		wm.clickValueByLinkText("Print Order");
	  
	  
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

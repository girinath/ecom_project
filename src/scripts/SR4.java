package scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR4 {
	WebDriver driver ;
	WrapperMethods wm;
	
  @Test
  public void compareProductWindows() throws InterruptedException {
	  wm.compareTitleString(Util.home_title);
	  wm.clickValueByXpathAttr("nav", "id","\"nav\"","/ol/li/a");
	  List<WebElement> ele = wm.selectElementsByLinkText("Add to Compare");
	  ele.get(1).click();
	  Thread.sleep(3000);
	  List<WebElement> ele2 = wm.selectElementsByLinkText("Add to Compare");
	  ele2.get(2).click();
	  wm.clickValueByXpathAttrOnly("button", "title", "\"Compare\"");	
	  wm.switchWindow("Products Comparison List - Magento Commerce");
	  System.out.println( wm.getValueById("product_comparison"));
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

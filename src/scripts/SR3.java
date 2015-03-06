package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR3 {
	WebDriver driver;
	WrapperMethods wm ;
  @Test
  public void exceedProductOrderLimit() throws InterruptedException {
	  wm.clickValueByXpathAttr("nav","id", "\"nav\"","/ol/li/a");
	  wm.selectDropdownByXpathandVisibleText("select", "title", "\"Sort By\"", "Name");
	  wm.clickValueByXpathAttr("ul", "class", "\"products-grid products-grid--max-4-col first last odd\"", "/li[3]/div/div[3]/button");
	  wm.xpathStartsWith("input", "cart[");
	  wm.xpathStartsWith("input", "cart[","1000");
	  wm.waitTillElementPresent();
	  System.out.println(  wm.getValueByCSSSelector("p","item-msg.error"));
	  wm.clickById("empty_cart_button");
	  System.out.println(wm.getTextBySelectValueByXpath("div", "class", "\"page-title\"", "/h1"));

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

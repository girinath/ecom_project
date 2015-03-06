package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR8 {
	WebDriver driver;
	WrapperMethods wm;

	@Test
  public void LogoVerify() {

 String txt = driver.findElement(By.xpath("//img[@alt=\"Magento Commerce\"]")).getAttribute("src");
 System.out.println(txt);
Assert.assertEquals("http://live.guru99.com/skin/frontend/rwd/default/images/logo.gif", txt);
	  
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

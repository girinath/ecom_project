package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Download {
	
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  FirefoxProfile fxProfile = new FirefoxProfile();

	    fxProfile.setPreference("browser.download.folderList",2);
	    fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
	    fxProfile.setPreference("browser.download.dir","c:\\mydownloads");
	    fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");

	    WebDriver driver = new FirefoxDriver(fxProfile);
	    driver.navigate().to("https://www.google.co.in/");
  }

  @AfterMethod
  public void afterMethod() {
  }

}

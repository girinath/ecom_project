package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR5 {
	WebDriver driver ;
	WrapperMethods wm ;

	@Test
	@Parameters ({"email"})
	public void createAccountAndShareWishlist(@Optional("adabc@gmail.com") String email) {
		// wm.clickValueByLinkText("Account");
		wm.clickValueByXpathAttrOnly("a", "class", "\"skip-link skip-account\"");
		wm.clickValueByLinkText("My Account");
		wm.clickValueByXpathAttrOnly("a", "title", "\"Create an Account\"");
		wm.setValueById("firstname", "giri");
		wm.setValueById("lastname", "nath");
		wm.setValueById("email_address", email);
		wm.setValueById("password", "nathgg");
		wm.setValueById("confirmation", "nathgg");
		
		wm.clickValueByXpathAttrOnly("button", "title", "\"Register\"");
		try {
			
			
			
			driver.findElement(By.className("success-msg")).isDisplayed();
//			System.out.println(wm.getValueByClass("success-msg"));
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(wm.getValueByClass("error-msg"));
			Assert.fail();
		}
		System.out.println(wm.getValueByClass("welcome-msg"));
		wm.clickValueByLinkText("TV");
		wm.clickValueByLinkText("Add to Wishlist");
		wm.setValueByXpathAttrOnly("textarea", "title", "\"Comment\"");
		wm.clickValueByName("save_and_share");
		wm.setValueById("email_address", "ggeyyy@gmail.com");
		wm.setValueById("message", "check this tv");
		wm.clickValueByXpathAttrOnly("button", "title","\"Share Wishlist\"");
		System.out.println(wm.getValueByClass("success-msg"));
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

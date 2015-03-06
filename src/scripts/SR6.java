package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import framework.WrapperMethods;

public class SR6 {
	WebDriver driver ;
	WrapperMethods wm ;
	

	@Test
	@Parameters({"email"})
	public void PurchaseProductsAndVerifyCost(String email) {
		wm.clickValueByXpathAttrOnly("a", "class", "\"skip-link skip-account\"");
		wm.clickValueByLinkText("My Account");
		wm.setValueById("email", email);
		wm.setValueById("pass", "nathgg");
		wm.clickById("send2");

		wm.clickValueByXpathAttr("div", "class", "\"block-content\"",
				"/ul/li[8]/a");
		wm.clickValueByXpathAttrOnly("button", "title", "\"Add to Cart\"");

		wm.selectDropdownByIdandVisibleText("country", "United States");
		wm.selectDropdownByIdandVisibleText("region_id", "New York");
		wm.setValueById("postcode", "12342");
		wm.clickValueByXpathAttrOnly("button", "title", "\"Estimate\"");

		String ship_cost = (wm.getTextBySelectValueByXpath("label", "for",
				"\"s_method_flatrate_flatrate\"", "/span"));
		wm.clickValueByXpathAttr("label", "for", "\"s_method_flatrate_flatrate\"", "/span");

		wm.clickValueByXpathAttrOnly("button", "title", "\"Update Total\"");

		String final_ship_cost = wm.getTextBySelectValueByXpath("table", "id",
				"\"shopping-cart-totals-table\"", "/tbody/tr[2]/td[2]/span");
		

		System.out.println(ship_cost + " " + final_ship_cost);
		if (ship_cost.equals(final_ship_cost)) {
			System.out.println("ship cost verified");
		}

		wm.clickValueByXpathAttrOnly("button", "title",
				"\"Proceed to Checkout\"");

		wm.setValueById("billing:street1", "MGR SALAI");
		wm.setValueById("billing:city", "Chennai");
		wm.selectDropdownByIdandVisibleText("billing:region_id", "California");
		wm.setValueById("billing:telephone", "23424");
		wm.setValueById("billing:postcode", "23433");

		wm.clickValueByXpathAttrOnly("button", "title", "\"Continue\"");

		wm.clickValueByXpathAttr("div", "id",
				"\"shipping-method-buttons-container\"", "/button");

		wm.clickById("p_method_checkmo");
		
		wm.clickValueByXpathAttr("div", "id", "\"payment-buttons-container\"",
				"/button");
		wm.clickValueByXpathAttr("div", "id", "\"review-buttons-container\"",
				"/button");
		
		System.out.println(wm.getValueByClass("page-title"));
		

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
package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Rail1 {
	WebDriver driver;

	@Test
	public void f() {

		Actions build = new Actions(driver);
		Action ee = build
				.sendKeys(driver.findElement(By.id("txtStationFrom")), "MAS")
				.sendKeys(Keys.TAB).build();
		ee.perform();
		Action ff = build
				.sendKeys(driver.findElement(By.id("txtStationTo")), "CBE")
				.sendKeys(Keys.ENTER).build();
		ff.perform();

		WebElement ele = driver.findElement(By.id("divTrainsListTrainsObj"));
		List<WebElement> rows = ele.findElements(By.tagName("tr"));

		String train = "KOVAI EXPRESS";
		int i = 0;
		for (WebElement e : rows) {

			String val = e.getText();
			if (val.contains(train)) {
				System.out.println(i);
				System.out.println(val);
				break;

			}
			i++;

		}
		System.out.println("i:" + i);

		List<WebElement> datas = rows.get(i).findElements(By.tagName("td"));

		String chk;
		for (int j = 0; j < datas.size(); j++) {
			chk = datas.get(j).getText();
			System.out.println("res:" + chk);
		}

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://erail.in/");
	}

	@AfterMethod
	public void afterMethod() {

	}

}

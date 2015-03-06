package framework;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperMethods {

	private WebDriver driver;

	public WrapperMethods(WebDriver driver) {
		/* this.driver = driver; */
		this.driver = driver;
		// driver = new FirefoxDriver();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Are\\Sel\\Ecom_project\\lib\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exitBrowser() {
		driver.close();
		driver.quit();
	}

	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValueById(String id) {
		String txt = "";

		try {
			txt = driver.findElement(By.id(id)).getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txt;
	}

	public void setValueById(String id, String value) {
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setValueByName(String id, String value) {
		try {
			driver.findElement(By.name(id)).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setValueByClass(String cls, String value) {
		try {
			driver.findElement(By.className(cls)).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValueByClass(String cls) {
		String txt = "";
		try {

			txt = driver.findElement(By.className(cls)).getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txt;
	}

	public void clickValueByClass(String cls) {
		try {
			driver.findElement(By.className(cls)).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickValueByName(String cls) {
		try {
			driver.findElement(By.name(cls)).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickValueByLinkText(String link) {
		try {
			driver.findElement(By.linkText(link)).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickValueByPartialLinkText(String link) {
		try {
			driver.findElement(By.partialLinkText(link)).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickValueByLinkTextAndIndex(String link, int indx) {
		try {

			List<WebElement> ele = driver.findElements(By.linkText(link));
			ele.get(indx).click();

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickByCSSSelectortags(String tag, String txt) {
		try {
			driver.findElement(
					By.cssSelector("td[class='product-cart-actions']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickByCSSSelector(String tag, String txt) {
		try {
			driver.findElement(By.cssSelector(tag + "." + txt)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValueByCSSSelector(String tag, String val) {
		String txt = "";
		try {

			txt = driver.findElement(By.cssSelector(tag + "." + val)).getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txt;

	}

	public void setValueByCSSSelector(String txt, String value) {
		try {
			driver.findElement(By.cssSelector(txt)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTitle() {
		String titleName = "";

		try {
			titleName = driver.getTitle();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titleName;
	}

	public List<WebElement> selectElementsByClassName(String classname) {
		List<WebElement> ele = null;
		try {
			ele = driver.findElements(By.className(classname));
			return ele;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}

	public List<WebElement> selectElementsByLinkText(String linkname) {
		List<WebElement> ele = null;
		try {
			ele = driver.findElements(By.linkText(linkname));
			return ele;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}

	public String[] storeWebElemetsByAttributeValueInStringArray(
			List<WebElement> ele, String attr) {
		String[] txt = new String[ele.size()];
		int i = 0;
		for (WebElement mobiles : ele) {
			txt[i] = mobiles.getAttribute(attr);
			System.out.println(txt[i]);
			i++;
		}
		return txt;
	}

	public void clickValueByXpathAttr(String tagname, String attr,
			String value, String tags) {
		try {
			driver.findElement(
					By.xpath("//" + tagname + "[@" + attr + "=" + value + "]"
							+ tags + "")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickValueByXpathAttrOnly(String tagname, String attr,
			String value) {
		try {
			driver.findElement(
					By.xpath("//" + tagname + "[@" + attr + "=" + value + "]"))
					.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void setValueByXpathAttrOnly(String tagname, String attr,
			String value) {
		try {
			driver.findElement(
					By.xpath("//" + tagname + "[@" + attr + "=" + value + "]"))
					.sendKeys("hiiii");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void waitTillElementPresent() {
		try {
			WebDriverWait upd = new WebDriverWait(driver, 20);
			upd.until(
					ExpectedConditions.presenceOfElementLocated(By
							.xpath("//button[@name=\"update_cart_action\"]")))
					.submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void submit() {

	}

	public void xpathStartsWith(String tagname, String value) {
		try {
			driver.findElement(By.xpath("//" + tagname
					+ "[starts-with(@name,'cart[')]"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void xpathStartsWith(String tagname, String value, String input) {
		try {
			driver.findElement(
					By.xpath("//" + tagname + "[starts-with(@name,'cart[')]"))
					.sendKeys(input);
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTextBySelectValueByXpath(String tagname, String attr,
			String value, String path) {
		String txt = "";
		try {
			txt = driver.findElement(
					By.xpath("//" + tagname + "[@" + attr + "=" + value + "]"
							+ path + "")).getText();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return txt;
	}

	public String getTextBySelectValueByXpathOnly(String tagname, String attr,
			String value) {
		String txt = "";
		try {
			txt = driver.findElement(
					By.xpath("//" + tagname + "[@" + attr + "=" + value + "]"))
					.getText();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return txt;
	}

	public void selectDropdownByXpathandVisibleText(String tagname,
			String attr, String value, String visibleText) {

		try {
			Select sortby = new Select(driver.findElement(By.xpath("//"
					+ tagname + "[@" + attr + "=" + value + "]")));
			sortby.selectByVisibleText(visibleText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectDropdownByIdandVisibleText(String id, String visibleText) {

		try {
			Select sortby = new Select(driver.findElement(By.id(id)));
			sortby.selectByVisibleText(visibleText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void compareTitleString(String str) {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(str)) {
			System.out.println("title is verified");
		}
	}

	public void checkStringArraySorted(String[] txt) {
		for (int j = 0; j < txt.length - 1; j++) {
			if (txt[j].compareTo(txt[j + 1]) > 0) {
				System.out.println("Array not sorted");

			}
		}
	}

	public void switchWindow(String windiwtitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
			if (driver.getTitle().equalsIgnoreCase(windiwtitle)) {
				break;
			}
		}

	}

}

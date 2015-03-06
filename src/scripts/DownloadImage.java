package scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DownloadImage {

	public static void main(String[] args) throws AWTException, InterruptedException {

		// TODO Auto-generated method stub

		FirefoxProfile fxProfile = new FirefoxProfile();
		Robot robot = new Robot();
		fxProfile.setPreference("browser.download.folderList", 2);
		fxProfile.setPreference("browser.download.manager.showWhenStarting",
				false);
		fxProfile.setPreference("browser.download.dir", "D:\\mydownloads\\");
		fxProfile.setAcceptUntrustedCertificates(true);
		fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		fxProfile
				.setPreference(
						"browser.helperApps.neverAsk.openFile",
						"text/csv, application/pdf, application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		fxProfile
				.setPreference(
						"browser.helperApps.neverAsk.saveToDisk",
						"text/csv, application/pdf, application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,image/png,image/pjpeg,image/jpeg,text/html,text/plain,application/msword,application/xml,application/excel");

		WebDriver driver = new FirefoxDriver(fxProfile);
		/*driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
		  driver.findElement(By.linkText("smilechart.xls")).click(); */
		
	driver.get("https://www.google.co.in/imghp?hl=en&tab=wi&ei=1x-cVOXuPI2UuATNioGACA&ved=0CAQQqi4oAg");
		
		driver.findElement(By.id("lst-ib")).sendKeys("iphone");
		driver.findElement(By.name("btnG")).click();
		Actions builder = new Actions(driver);
		
		WebElement ee = driver.findElement(By.id("lst-ib"));

		
		Action rtclick = builder
				.moveToElement(driver.findElement(By.name("bE1E7RAh77zWPM:")))
				.contextClick().sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();

		rtclick.perform();
		Thread.sleep(2000);
		try {
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WinWaitActive("Save As").
		// Send("{ENTER}");
		// Action rtclick =
		// builder.contextClick(driver.findElement(By.name("qCvEQrRQaWGwWM:")));

	}

}

package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test(priority = 1)
	public void verifyWebsiteSecondHeadingTest() {
		// Assert page title
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"entry-content clear\"]/h2")).getText(),
				"Quia quis non");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}

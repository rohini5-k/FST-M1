package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test(priority = 1)
	public void navigatetoJobPageTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Jobs – Alchemy Jobs");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}

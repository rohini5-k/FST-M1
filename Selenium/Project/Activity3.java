package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test(priority = 1)
	public void getHeaderURL() {
		// Assert page title
		System.out.println((driver.findElement(By.xpath("//*[@class=\"attachment-large size-large wp-post-image\"]")).getAttribute("src")));
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}

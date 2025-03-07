package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test(priority = 1)
	public void searchJobandApplyTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='search_keywords']")).sendKeys("banking");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='Search Jobs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='job_listings']/li/a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='Apply for job']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@class='job_application_email']")).getText());
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}

package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test(priority = 1)
	public void logintoBackendTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("pa$$w0rd");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}

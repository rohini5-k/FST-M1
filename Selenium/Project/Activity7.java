package fst_seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Firefox driver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test(priority = 1)
	public void createJob() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-26\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='create_account_email']")).sendKeys("you@ok.com");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='job_title']")).sendKeys("Test Job");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='job_location']")).sendKeys("London");
		//Thread.sleep(2000);
		Select obj = new Select (driver.findElement(By.xpath("//*[@name='job_type']")));
		obj.selectByValue("2");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mceu_16']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mceu_16']")).sendKeys("Description");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='application']")).sendKeys("https://alchemy.hguy.co");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='company_name']")).sendKeys("ABC");
		Thread.sleep(2000);
		
		
		
		driver.findElement(By.xpath("//*[@name='submit_job']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@name='continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@class='job_application_email']")).getText());
	}

	//@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}

package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4_ToDoList {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://v1.training-support.net/selenium");
		
	}
	
	@Test
	public void addingToDoList() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		//List<WebElement> cardElements = driver.findElements(AppiumBy.className("android.view.View"));
		//System.out.println("Before scroll: " + cardElements.size());
		
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(3)"));
		driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, 'To-Do List')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("1");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("2");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("3");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		
		List<WebElement> taskList= driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View/android.view.View"));
		System.out.println("Number of tasks added: "+taskList.size());
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]")).click();
		taskList= driver.findElements(AppiumBy.id("tasksList"));
		int taskCount= taskList.size();
		System.out.println("Number of tasks left: "+taskCount);
		
		Assert.assertEquals(taskCount, 0);	
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}

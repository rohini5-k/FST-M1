package examples;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LocatorsTest {
//Declare Appium driver
	AppiumDriver driver;
	
//Setup method
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//Desired Capabilities
		UiAutomator2Options options= new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		/*ForIOS
		XCUITestOptions iosOptions= new XCUITestOptions();
		iosOptions.setPlatformName("ios");
		iosOptions.setAutomationName("XCUITest");
		iosOptions.setApp("/path/to/app.ipa");
		iosOptions.noReset();*/
		
		//Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		
		//Initialize the driver
		driver= new AndroidDriver(serverURL, options);
		
	}
	
	//Test Function
	@Test
	public void addTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//Assertions
		String result= driver.findElement(AppiumBy.id("result")).getText();
		assertEquals(result, "14");
		
	}
	
	//Tear down method
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}

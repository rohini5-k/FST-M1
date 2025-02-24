package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3_GoogleKeepReminder {

    AndroidDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void createNewNoteWithReminder() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test3");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")).sendKeys("Hello Appium");
        
        //Click on Reminder icon
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        Thread.sleep(1000);
        //Click on pick a date and time
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]")).click();
        Thread.sleep(1000);
        //Click on time field selected by default
        driver.findElement(AppiumBy.id("com.google.android.keep:id/time_spinner")).click();
        //Click on Pick a time
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/text' and @text='Pick a time…']")).click();
        //driver.findElement(AppiumBy.id("com.google.android.keep:id/text")).click();
        //Search for 3 o'click and click on it
        driver.findElement(AppiumBy.accessibilityId("3 o'clock")).click();
        //Click on OK button
        driver.findElement(By.id("com.google.android.keep:id/material_timepicker_ok_button")).click();
        Thread.sleep(1000);
        //Click on Save button
        driver.findElement(AppiumBy.id("com.google.android.keep:id/save")).click();
        Thread.sleep(1000);
        //Come out of the notes screen
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(1000);
        WebElement notes= driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[contains(@content-desc, 'Test3')]"));
        if(notes.isDisplayed()){
        		System.out.println("Note was successfully added!");
        } else {
        System.out.println("Note was not added.");
        }
        
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/drawer_navigation_reminders")).click();
        WebElement reminder= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and contains(@text, 'Test3')]"));
        if(reminder.isDisplayed()){
    		System.out.println("Reminder was successfully added!");
	    } else {
	    System.out.println("Reminder was not added.");
	    }
        

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

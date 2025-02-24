package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2_GoogleKeep {
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
    public void createNewNote() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test2");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")).sendKeys("Hello Appium");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(1000);
        WebElement notes= driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[contains(@content-desc, 'Test2')]"));
        if(notes.isDisplayed()){
        		System.out.println("Note was successfully added!");
        } else {
        System.out.println("Note was not added.");
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

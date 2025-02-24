package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1_GoogleTask {

AndroidDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void createTask() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        String task1= "Complete Activity with Google Tasks";
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys(task1);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
        Thread.sleep(1000);
        
        WebElement tasks1= driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[contains(@content-desc, 'Task')]"));
        Assert.assertEquals(tasks1.getAttribute("content-desc"), task1);
        
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(1000);
        String task2= "Complete Activity with Google Keep";
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys(task2);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
        Thread.sleep(1000);
        
        WebElement tasks2= driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[contains(@content-desc, 'Keep')]"));
        Assert.assertEquals(tasks2.getAttribute("content-desc"), task2);
        
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(1000);
        String task3= "Complete the second Activity Google Keep";
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys(task3);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
        Thread.sleep(1000);
        
        WebElement tasks3= driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[contains(@content-desc, 'second')]"));
        Assert.assertEquals(tasks3.getAttribute("content-desc"), task3);
 

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

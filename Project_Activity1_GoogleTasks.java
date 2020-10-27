package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity1_GoogleTasks {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "4968f5e");
        caps.setCapability("deviceName", "Mi A2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void createActivities() {
        // Click on add new contact floating button
    	List<String> addTaskLists = new ArrayList<String>(3);
    	List<String> addedTaskLists = new ArrayList<String>(3);
    	addTaskLists.add("Complete Activity with Google Tasks");
    	addTaskLists.add("Complete Activity with Google Keep");
    	addTaskLists.add("Complete the second Activity Google Keep");
    	
    	for (String task : addTaskLists) {
    		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']").click();
            // Wait for contact card to appear
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
            driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(task);
            driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		}
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
    	List<MobileElement> taskLists= driver.findElementsById("com.google.android.apps.tasks:id/task_name");
    	
    	for (MobileElement taskName : taskLists) {
    		for(String task : addTaskLists) {
    			if(taskName.getText().equals(task)){
    	  			  addedTaskLists.add(taskName.getText());
    	  			  break;
    			}
    		}
    	}
    	
    	Collections.sort(addTaskLists);
    	Collections.sort(addedTaskLists);
    	Assert.assertTrue(addTaskLists.equals(addedTaskLists));
    	
    }
    
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}

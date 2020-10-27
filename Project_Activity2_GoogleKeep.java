package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity2_GoogleKeep {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "4968f5e");
        caps.setCapability("deviceName", "Mi A2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", "com.google.android.apps.keep.ui.activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addNotes() {
    	driver.findElementById("com.google.android.keep:id/new_note_button").click();
    	driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Note1");
    	driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Note1 Description");
    	driver.findElementByAccessibilityId("Navigate up").click();
    	Assert.assertEquals("Note1",driver.findElementById("com.google.android.keep:id/index_note_title").getText());
    	Assert.assertEquals("Note1 Description",driver.findElementById("com.google.android.keep:id/index_note_text_description").getText());
    }
    
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}

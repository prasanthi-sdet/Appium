package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session1_Activity2 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	 DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("deviceId", "4968f5e");
         caps.setCapability("deviceName", "Mi A2");
         caps.setCapability("platformName", "Android");
         caps.setCapability("appPackage", "com.google.android.calculator");
         caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addNumbers() {
    	    	
    	driver.findElementByAccessibilityId("10").click();
		driver.findElementById("mul").click();
		driver.findElementById("digit5").click();
		driver.findElementById("equal").click();
		String result = driver.findElementById("input_edit").getText();	
		System.out.println("10 x 5 = :"+result);
    }
    
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}

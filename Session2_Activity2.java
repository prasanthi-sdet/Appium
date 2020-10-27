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

public class Session2_Activity2 {
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

    @Test (priority = 0)
    public void add(){
    	    	
  	  	driver.findElementByAccessibilityId("5").click();
  	  	driver.findElementById("plus").click();
  	  	driver.findElementByAccessibilityId("9").click();
  	  	driver.findElementById("equal").click();
  	  	String result = driver.findElementById("input_edit").getText();
  	  	Assert.assertEquals(result, "14");  	  	
    }    

    @Test (priority = 1)
    public void minus(){
    	    	
  	  	driver.findElementByAccessibilityId("10").click();
  	  	driver.findElementById("plus").click();
  	  	driver.findElementByAccessibilityId("2").click();
  	  	driver.findElementById("minus").click();
  	  	String result = driver.findElementById("input_edit").getText();
  	  	Assert.assertEquals(result, "8");  	  	
    }

    @Test (priority = 2)
    public void multiply(){
    	    	
  	  	driver.findElementByAccessibilityId("10").click();
  	  	driver.findElementById("plus").click();
  	  	driver.findElementByAccessibilityId("2").click();
  	  	driver.findElementById("mul").click();
  	  	String result = driver.findElementById("input_edit").getText();
  	  	Assert.assertEquals(result, "20");  	  	
    }

    @Test (priority = 3)
    public void divide(){
    	    	
  	  	driver.findElementByAccessibilityId("10").click();
  	  	driver.findElementById("plus").click();
  	  	driver.findElementByAccessibilityId("2").click();
  	  	driver.findElementById("div").click();
  	  	String result = driver.findElementById("input_edit").getText();
  	  	Assert.assertEquals(result, "5");  	  	
    }
    
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}

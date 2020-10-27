package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session2_Activity3 {
	    AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	         caps.setCapability("deviceId", "4968f5e");
	         caps.setCapability("deviceName", "Mi A2");
	         caps.setCapability("platformName", "android");
	         caps.setCapability("appPackage", "com.android.contacts");
	         caps.setCapability("appActivity", ".DialtactsContactsEntryActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 10);

	        driver.get("https://www.training-support.net/");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }

	    @Test
	    public void addContact(){

	    	driver.findElementByAccessibilityId("Create new contact").click();
	    	driver.findElementByXPath("//android.widget.EditText[@text = 'Name']").sendKeys("Aaditya Vardhan");
	    	driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").sendKeys("123456789");
	    	driver.findElementByXPath("//android.widget.Button[@text = 'Done']").click();
	    	driver.findElementByXPath("//android.widget.EditText[@text = 'Search among 2859 contacts']").sendKeys("Aaditya Vardhan");
	    	String contactName = driver.findElementByXPath("//android.widget.TextView[@text = 'Aaditya Vardhan']").getText();
	    	Assert.assertEquals(contactName, "Aaditya Vardhan");
	    }
	    

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
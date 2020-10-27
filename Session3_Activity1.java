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

public class Session3_Activity1 {
	    AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	         caps.setCapability("deviceId", "4968f5e");
	         caps.setCapability("deviceName", "Mi A2");
	         caps.setCapability("platformName", "android");
	         caps.setCapability("appPackage", "com.android.mms");
	         caps.setCapability("appActivity", ".ui.ConversationList");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 20);

	        driver.get("https://www.training-support.net/");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }

	    @Test
	    public void sendSms(){

	    	driver.findElementByXPath("//android.widget.LinearLayout[3]/android.widget.Button[2]").click();
	    	driver.findElementByAccessibilityId("Add Contact").click();
	    	driver.findElementByXPath("//android.widget.EditText[@text = 'Search among 120 contacts']").click();
	    	driver.findElementByXPath("//android.widget.EditText[@text = 'Search among 120 contacts']").sendKeys("Adithya");
	    	driver.findElementByXPath("//android.widget.TextView[@text = 'Adithya']").click();
	    	driver.findElementByXPath("//android.widget.Button[@text = 'Done']").click();
	    	driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Please be safe!!!");
	    	driver.findElementById("com.android.mms:id/send_button").click();
	    	driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.Button").click();
	    	String contactName = driver.findElementById("com.android.mms:id/from").getText();
	    	String msg = driver.findElementById("com.android.mms:id/subject").getText();
	    	Assert.assertEquals(contactName, "Adithya");
	    	Assert.assertEquals(msg, "Please be safe!!!");
	    }
	    

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
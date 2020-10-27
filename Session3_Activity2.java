package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class Session3_Activity2 {
	    AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	         caps.setCapability("deviceId", "4968f5e");
	         caps.setCapability("deviceName", "Mi A2");
	         caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 10);

	        driver.get("https://www.training-support.net/selenium/lazy-loading");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }

	    @Test
	    public void getNumberofImages() {
	    	
	    	MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
	    	wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
	    	List<MobileElement> numberOfImages2 = driver.findElementsByClassName("android.widget.Image");
	    	System.out.println("Number of Images :"+numberOfImages2.size());
	    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"helen\"))"));
	    	List<MobileElement> numberOfImages1 = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	    	Assert.assertEquals(numberOfImages1.size(), 4);
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
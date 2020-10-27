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

public class Session2_Activity1 {
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

	        driver.get("https://www.training-support.net/");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }

	    @Test
	    public void getPageTitles() {
	    	
	    	String title = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	    	Assert.assertEquals(title, "Training Support");
	    	
	    	driver.findElementByXPath("//android.view.View[@content-desc=\"About Us\"]/android.widget.TextView").click();
	    	String newtitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
	    	Assert.assertEquals(newtitle, "About Us");
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
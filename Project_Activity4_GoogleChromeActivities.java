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

public class Project_Activity4_GoogleChromeActivities {
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

	        driver.get("https://www.training-support.net/selenium");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }

	    @Test
	    public void todoListScrollTest() {
	    	
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));        
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollTextIntoView(\"To-Do List\")")).click();
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("taskInput"))); 
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("test");
	        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"test\")")));
	  	  	String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"test\")")).getText();
	  	  	Assert.assertEquals("test",result);
	  	  	List<MobileElement> ele=driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.view.View[2]");
	  	  	System.out.println("No of elements"+ele.size());
	  	  	driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();
	    }
	    
	    
	    @Test
	    public void logintoHomewithValidCredentials() {
	    	
	  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	  	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();
	  	  
	  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
	  	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
	  	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  	  String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Welcome Back, admin\")")).getText();	
	  	  Assert.assertEquals("Welcome Back, admin",result);
	    }	  
	    
	    @Test
	    public void logintoHomewithInvalidCredentials() {
	    	
	  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	  	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();
	  	  
	  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("adminn");
	  	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("passwo0rd");
	  	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  	  String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Invalid Credentials\")")).getText();	
	  	  Assert.assertEquals("Invalid Credentials",result);
	  	  
	    }	  
	    
	    @Test
	    public void logintoPopupswithValidCredentials() {
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Sign In\")")));
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  	  	
	  	  	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  	  	String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Welcome Back, admin\")")).getText();
	  	  	Assert.assertEquals("Welcome Back, admin",result);
	  	  	
	    }	  
	    
	    @Test
	    public void logintoPopupswithInvalidCredentials() {
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Sign In\")")));
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  	  	
	  	  	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("adminn");
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("passwo0rd");
	  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  	  	String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Invalid Credentials\")")).getText();	
	  	  	Assert.assertEquals("Invalid Credentials",result);
	  	  
	    }	  

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
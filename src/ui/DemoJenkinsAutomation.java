package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoJenkinsAutomation {
	
	String username = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String buildName = System.getenv("JENKINS_LABEL");
	WebDriver driver;
	
	@Test
	public void chromeTest1() throws MalformedURLException {
		
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "100.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		Assert.assertEquals(bstackdemoTestUtil(demo_username, demo_password), 1);
	}
	
	
	public int bstackdemoTestUtil(String demo_username, String demo_password) {
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("signin")).click();
		synchronized (driver){
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[2]/div[1]/div/div[1]")).click();
		driver.findElement(By.id("react-select-2-input")).sendKeys(demo_username, Keys.ENTER);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[2]/div[2]/div/div[1]")).click();
		driver.findElement(By.id("react-select-3-input")).sendKeys(demo_password, Keys.ENTER);
		driver.findElement(By.id("login-btn")).click();
		synchronized (driver){
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			String logged_in_user = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/span")).getText();
			if(!logged_in_user.equals(username)) {
				return 0;
			}
			
		} catch(Exception e) {
			return 0;
		}
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div[2]/div[4]")).click();
		synchronized (driver){
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[3]/div[3]")).click();
		synchronized (driver){
			try {
				driver.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		driver.findElement(By.id("firstNameInput")).sendKeys("sample_first_name");
		driver.findElement(By.id("lastNameInput")).sendKeys("sample_last_name");
		driver.findElement(By.id("addressLine1Input")).sendKeys("sample_address");
		driver.findElement(By.id("provinceInput")).sendKeys("sample_province");
		driver.findElement(By.id("postCodeInput")).sendKeys("sample_postal_code");
		driver.findElement(By.id("checkout-shipping-continue")).click();
		synchronized (driver){
			try {
				driver.wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String str = driver.findElement(By.id("confirmation-message")).getText();
		int ret_val = 0;
		if(str.contains("successful")) {
			ret_val = 1;
		}
		return ret_val;
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

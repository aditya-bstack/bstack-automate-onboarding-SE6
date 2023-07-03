package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoJenkinsAutomation {
	
	String username = System.getenv("BROWSERSTACK_USERNAME");
	String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	
	
	@Test
	public void chromeTest1() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		/*MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "103.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "11");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);*/
		driver = new InternetExplorerDriver();
		String ret = bstackdemoTestUtil(driver,demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Chrome Test1 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Chrome Test1 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	/*@Test
	public void chromeTest2() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "111.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Ventura");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Chrome Test2 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Chrome Test2 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void firefoxTest1() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demousers";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Firefox");
		capabilities.setCapability("browserVersion", "102.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Firefox Test1 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Firefox Test1 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void firefoxTest2() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Firefox");
		capabilities.setCapability("browserVersion", "112.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Big Sur");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Firefox Test2 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Firefox Test2 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void ieTest1() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "IE");
		capabilities.setCapability("browserVersion", "11.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("IE Test1 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("IE Test1 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void ieTest2() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "IE");
		capabilities.setCapability("browserVersion", "11.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "8.1");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("IE Test2 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("IE Test2 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void safariTest1() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("browserVersion", "13.1");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Catalina");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Safari Test1 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Safari Test1 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void safariTest2() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demousers";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("browserVersion", "16.3");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Ventura");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Safari Test2 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Safari Test2 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void edgeTest1() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Edge");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "11");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Edge Test1 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Edge Test1 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}
	
	@Test
	public void edgeTest2() throws MalformedURLException {
		WebDriver driver;
		String demo_username = "demouser";
		String demo_password = "testingisfun99";
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Edge");
		capabilities.setCapability("browserVersion", "111.0");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
		browserstackOptions.put("buildName", buildName);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
		String ret = bstackdemoTestUtil(driver, demo_username, demo_password);
		//Assert.assertEquals(ret, "success");
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();
		argumentsObject.put("status", "<passed/failed>");
		argumentsObject.put("reason", "<reason>");
		executorObject.put("action", "setSessionStatus");
		executorObject.put("arguments", argumentsObject);
		jse.executeScript(String.format("browserstack_executor: %s", executorObject));
		if(ret.equals("success")) {
			System.out.println("Edge Test2 Passed");
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Successfully placed order\"}}");
		}
		else {
			System.out.println("Edge Test2 Failed");
		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+ret+"\"}}");

		}
		driver.quit();
	}*/
	
	public String bstackdemoTestUtil(WebDriver driver, String demo_username, String demo_password) {
		try {
				driver.get("https://bstackdemo.com/");
				driver.manage().window().maximize();
				synchronized (driver){
					driver.wait(5000);
				}
				driver.findElement(By.id("signin")).click();
				synchronized (driver){
					driver.wait(2000);
				}
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[2]/div[1]/div/div[1]")).click();
				driver.findElement(By.id("react-select-2-input")).sendKeys(demo_username, Keys.ENTER);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[2]/div[2]/div/div[1]")).click();
				driver.findElement(By.id("react-select-3-input")).sendKeys(demo_password, Keys.ENTER);
				driver.findElement(By.id("login-btn")).click();
				synchronized (driver){
					driver.wait(5000);
				}
				
				String logged_in_user = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/span")).getText();
				if(!logged_in_user.equals(demo_username)) {
					return "Invalid Credentials";
				}
					
				driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div[2]/div[4]")).click();
				synchronized (driver){
					driver.wait(2000);
				}
				driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[3]/div[3]")).click();
				synchronized (driver){
					driver.wait(2000);
				}
				driver.findElement(By.id("firstNameInput")).sendKeys("sample_first_name");
				driver.findElement(By.id("lastNameInput")).sendKeys("sample_last_name");
				driver.findElement(By.id("addressLine1Input")).sendKeys("sample_address");
				driver.findElement(By.id("provinceInput")).sendKeys("sample_province");
				driver.findElement(By.id("postCodeInput")).sendKeys("sample_postal_code");
				driver.findElement(By.id("checkout-shipping-continue")).click();
				synchronized (driver){
					driver.wait(5000);
				}
				
				if (driver.findElement(By.id("confirmation-message")).isDisplayed()){
					return "success";
				}
				else {	
					return "no confirmation received";
				}
		}
		catch (NoSuchElementException e) {
			return "error occurred";
		}
		catch (InterruptedException e) {
			return e.toString();
		}
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}

package com.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryManager {

	//public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			//new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
	


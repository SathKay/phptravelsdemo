package com.qa.phptravels.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsManager {
	
	public Properties prop;
	public ChromeOptions co;
	public FirefoxOptions fo;
	public SafariOptions so;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		
		return fo;
	}
	
	//write same method for safari browser as well

}

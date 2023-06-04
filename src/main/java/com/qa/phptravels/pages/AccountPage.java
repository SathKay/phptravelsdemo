package com.qa.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.phptravels.utils.Constants;
import com.qa.phptravels.utils.ElementUtils;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By logoutLink = By.xpath("//ul[@class='sidebar-menu list-items']/li/a[text()=' Logout']");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayedWithWait(logoutLink, Constants.DEFAULT_TIMEOUT);
	}

}

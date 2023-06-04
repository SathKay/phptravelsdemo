package com.qa.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.phptravels.utils.Constants;
import com.qa.phptravels.utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By emailId = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By signupBtn = By.xpath("//div/a/span[text()='Signup']");
	private By resetPasswordLink = By.xpath("//label[text()='Reset Password']");
	private By rememberMeChkBox = By.xpath("//label[text()='Remember Me']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}
	
	public String getLoginPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}
	
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL, Constants.DEFAULT_TIMEOUT);
	}
	
	public AccountPage doLogin(String username, String password) {
		eleUtil.doSendKeys(emailId, username);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
	}
	
	public boolean isResetPasswordLinkExists() {
		return eleUtil.doIsDisplayed(resetPasswordLink);
	}

}

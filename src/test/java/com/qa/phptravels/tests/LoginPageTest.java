package com.qa.phptravels.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.phptravels.utils.Constants;
import com.qa.phptravels.utils.ExcelUtil;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {	
		Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl().contains(Constants.LOGIN_PAGE_URL));
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		return ExcelUtil.getTestData(Constants.EXCEL_TEST_DATA);
	}
	
	@Test(priority=1,dataProvider="getLoginTestData")
	public void loginTest(String username, String password) {
		//accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		accPage = loginPage.doLogin(username, password);
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void resetpasswordLinkTest() {
		Assert.assertTrue(loginPage.isResetPasswordLinkExists());
	}

}

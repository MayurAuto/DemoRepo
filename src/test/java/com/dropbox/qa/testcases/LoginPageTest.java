package com.dropbox.qa.testcases;

import com.dropbox.qa.base.TestBase;
import com.dropbox.qa.pages.HomePage;
import com.dropbox.qa.pages.LoginPage;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Login - Dropbox");
    }

    @Test(priority = 2)
    public void logoVisibilityTest() {
        boolean flag = loginPage.dropLogoVisibility();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() throws IOException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

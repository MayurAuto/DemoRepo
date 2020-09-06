package com.dropbox.qa.testcases;

import com.dropbox.qa.base.TestBase;
import com.dropbox.qa.pages.HomePage;
import com.dropbox.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() throws IOException {
        super();
    }
    //All test cases should be independent
    //Before each test case launch the browser and login into the Application
    //@Test -- Execution of all the test cases
    //After each test case quit the browser

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String input = homePage.verifyHomePageTitle();
        Assert.assertEquals("input","Dropbox","Home Page title not matched");
    }

    @Test(priority = 2)
    public void verifyHomePageHeaderTest(){
        boolean flag = homePage.homePageHeader();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void clickOnSearchFieldTest(){
        homePage.clickOnSearchField("I'm here Inside :-)");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

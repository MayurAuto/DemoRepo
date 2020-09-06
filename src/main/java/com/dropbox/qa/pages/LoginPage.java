package com.dropbox.qa.pages;

import com.dropbox.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {

    //Page factory - (Object Repository)
    @FindBy(name = "login_email")
    WebElement userName;

    @FindBy(name = "login_password")
    WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[contains(@class, 'dropbox-logo__glyph')]")
    WebElement dropLogo;

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean dropLogoVisibility() {
        return dropLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd) throws IOException {

        userName.sendKeys(un);
        passWord.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }


}

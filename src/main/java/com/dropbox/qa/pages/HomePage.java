package com.dropbox.qa.pages;

import com.dropbox.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.io.IOException;

public class HomePage extends TestBase {

    @FindBy(xpath = "//h1[contains(text(), 'Home')]")
    WebElement pageHeader;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchField;


    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean homePageHeader(){
        return pageHeader.isDisplayed();
    }

    public void clickOnSearchField(String input){
        searchField.sendKeys(input);
    }
}

package com.dropbox.qa.testcases;

import com.dropbox.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JustTesting {

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\Application_Testing\\src\\" +
                "main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get("https://www.dropbox.com/login");

    }
}

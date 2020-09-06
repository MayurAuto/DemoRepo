package com.dropbox.qa.base;

import com.dropbox.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException {

        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\Application_Testing\\src\\main" +
                "\\java\\com\\dropbox\\qa\\config\\config.properties");
        prop.load(ip);
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\Application_Testing\\src\\" +
                    "main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("Driver is not recognized");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


    }
}

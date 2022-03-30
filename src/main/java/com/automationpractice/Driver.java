package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;
    private DesiredCapabilities capabilities;


    public void initializeBrowser(String browser) {
        capabilities = new DesiredCapabilities();
        switch (browser) {
            case "Chrome":
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--disable-geolocation");
                chrome_options.addArguments("--incognito");
                System.setProperty("webdriver.chrome.driver", "selenium-chrome-driver-3.141.59.jar");
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);
                driver = new ChromeDriver(capabilities);
                break;
            case "Firefox":
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("geo.prompt.testing", true);
                firefoxProfile.setPreference("geo.prompt.testing.allow", true);
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;

        }

    }




}
















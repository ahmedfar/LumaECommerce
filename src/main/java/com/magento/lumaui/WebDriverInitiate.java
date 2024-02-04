package com.magento.lumaui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WebDriverInitiate {


    static String URL = "https://magento.softwaretestingboard.com/";
    static WebDriver driver = null;

    public static WebDriver getDriver(){
        if(driver==null){
            driver = startApp();
        }
        return driver;
    }

    public  static WebDriver startApp(){
        //WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        // Maximize the browser
        driver.manage().window().maximize();
        // Launch Website
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return  driver;
    }

    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    public static void hoverElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public static void closeApp(){
        driver.quit();
    }
}

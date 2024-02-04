package com.magento.luma.pageController;

import com.magento.luma.WebDriverInitiate;
import org.openqa.selenium.WebDriver;

public class LumaUIController {

    WebDriver driver = null;
    private static HomePageController homePageController = null;

    public void startApp(){
        driver = WebDriverInitiate.startApp();
    }

    public PageBaseController homePage(){
        if(homePageController == null){
            homePageController = new HomePageController(driver);
        }
        return homePageController;
    }
}

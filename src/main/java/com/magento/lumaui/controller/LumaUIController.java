package com.magento.lumaui.controller;

import com.magento.lumaui.WebDriverInitiate;
import org.openqa.selenium.WebDriver;

public class LumaUIController {

    WebDriver driver = null;
    private static HomePageController homePageController = null;
    private static SearchResultPageController searchResultPageController = null;

    public void startApp(){
        driver = WebDriverInitiate.startApp();
    }

    public void closeApp(){
        driver.close();
    }

    public PageBaseController homePage(){
        if(homePageController == null){
            homePageController = new HomePageController(driver);
        }
        return homePageController;
    }

    public SearchResultPageController searResultPage(){
        if(searchResultPageController==null){
            searchResultPageController = new SearchResultPageController(driver);
        }
        return searchResultPageController;
    }
}

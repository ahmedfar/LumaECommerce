package com.magento.luma.pageController;

import com.magento.luma.WebDriverInitiate;
import com.magento.luma.pageModel.PageBaseModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.time.Duration;

public class PageBaseController extends PageBaseModel {

    WebDriver driver = null;

    public PageBaseController(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickLumaLogo(){
        logoLink().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    public void validateHomePageExist(){
        String expectedUrl = WebDriverInitiate.getUrl();
        Assert.assertEquals("https://magento.softwaretestingboard.com/", expectedUrl);
    }

    public void search(String searchText){
        searchTextBox().sendKeys(searchText);
        searchButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }




}

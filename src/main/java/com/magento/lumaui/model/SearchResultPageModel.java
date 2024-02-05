package com.magento.lumaui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SearchResultPageModel {

    WebDriver driver = null;

    public SearchResultPageModel(WebDriver driver){
        this.driver = driver;
    }

    public WebElement goToHomePageLink(){
        return driver.findElement(By.partialLinkText("Home"));
    }

    public WebElement searchResultForText(){
        return driver.findElement(By.xpath("//li[contains(@class, 'item search')]/strong"));
    }

    public WebElement searchResultPageTitleText(){
        return driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]/span"));
    }

    public WebElement gridViewLink(){
        return driver.findElement(By.xpath("//a[@title='Grid']/"));
    }

    public WebElement listViewLink(){
        return driver.findElement(By.xpath("//a[@title='List']/"));
    }

    public Select sortComboBox(){
        WebElement element = driver.findElement(By.id("sorter"));
        Select comboBox = new Select(element);
        return  comboBox;
    }

}

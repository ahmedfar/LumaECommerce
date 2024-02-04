package com.magento.lumaui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBaseModel {

    WebDriver driver = null;

    public PageBaseModel(WebDriver driver){
        this.driver = driver;
    }

    public WebElement logoLink(){
        return driver.findElement(By.xpath("//a[contains(@class,'logo')]"));
    }

    public WebElement logoImage(){
        return driver.findElement(By.xpath("//a[contains(@class,'logo')]/img"));
    }

    public WebElement singInLink(){
        return driver.findElement(By.partialLinkText("Sign In"));
    }

    public WebElement createNewAccountLink(){
        return driver.findElement(By.linkText("Create an Account"));
    }

    public WebElement searchTextBox(){
        return driver.findElement(By.id("search"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.xpath("//button[contains(@title, 'Search')]"));
    }

    public WebElement MyCartLink(){
        return driver.findElement(By.xpath("//a/span[contains(text(),'My Cart')]/.."));
    }

    public WebElement MyCartCounterText(){
        return driver.findElement(By.xpath("//a/span[contains(text(),'My Cart')]/..//span[contains(@class,'counter-number')]"));
    }





}

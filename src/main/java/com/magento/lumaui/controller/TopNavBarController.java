package com.magento.lumaui.controller;

import com.magento.lumaui.WebDriverInitiate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TopNavBarController {

    WebDriver driver = null;

    public TopNavBarController(WebDriver driver){
        this.driver = driver;
    }

    private WebElement navBarElement(){
        return driver.findElement(By.xpath("//nav[contains(@class,'navigation')]"));
    }

    public void selectNavBarItem(String item){
        String[] menuList = item.split(">");
        WebElement menuElement = navBarElement();
        for(int i=0; i<menuList.length; i++){
            if(i<menuList.length-1){
                menuElement = menuElement.findElement(By.xpath("//li/a/span[contains(text(),'" + menuList[i] + "')]"));
                WebDriverInitiate.hoverElement(menuElement);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }
            if(i==menuList.length-1){
                menuElement = menuElement.findElement(By.xpath("//li/a/span[contains(text(),'" + menuList[i] + "')]/.."));
                menuElement.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }
        }
    }

    public List<String> getMenuItemList(String item) {

        List<String> listItems = new ArrayList<>();
        List<WebElement> menuElementList = null;
        String[] menuList = null;

        WebElement menuElement = navBarElement();

        if (item != null) {
            menuList = item.split(">");
            for (int i = 0; i < menuList.length; i++) {

                menuElement = menuElement.findElement(By.xpath("ul/li/a/span[contains(text(),'" + menuList[i] + "')]/../.."));
                if (i < menuList.length) {
                    WebDriverInitiate.hoverElement(menuElement);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                }
                if (i == menuList.length - 1) {
                    menuElementList = menuElement.findElements(By.xpath("ul/li/a/span[normalize-space(text())]"));
                    for (WebElement element : menuElementList) {
                        listItems.add(element.getText());
                    }
                }
            }

        }
        else {
            menuElementList = menuElement.findElements(By.xpath("ul/li/a/span[normalize-space(text())]/../"));
            for (WebElement element : menuElementList) {
                listItems.add(element.findElement(By.xpath("span")).getText());
            }
        }
        return listItems;
    }


}

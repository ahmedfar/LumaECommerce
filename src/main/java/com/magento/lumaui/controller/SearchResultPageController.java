package com.magento.lumaui.controller;

import com.magento.lumaui.model.SearchResultPageModel;
import org.openqa.selenium.WebDriver;

public class SearchResultPageController extends SearchResultPageModel {

    public SearchResultPageController(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultPageTitle(){
        String title = searchResultPageTitleText().getText();
        return title;
    }
}

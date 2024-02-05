package luma;

import com.magento.lumaui.WebDriverInitiate;
import com.magento.lumaui.controller.LumaUIController;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends LumaUIBaseTest{

    @Test
    public void pageValidationTest(){
        String expectedUrl = WebDriverInitiate.getUrl();
        Assert.assertEquals("https://magento.softwaretestingboard.com/", expectedUrl);
        Assert.assertTrue(lumaUI.homePage().logoImage().isDisplayed());
        Assert.assertTrue(lumaUI.homePage().logoLink().isDisplayed());
        Assert.assertTrue(lumaUI.homePage().singInLink().isDisplayed());
        Assert.assertTrue(lumaUI.homePage().createNewAccountLink().isDisplayed());
        Assert.assertTrue(lumaUI.homePage().MyCartLink().isDisplayed());
    }

    @Test
    public void logoHomePageValidationTest(){
        lumaUI.homePage().clickLumaLogo();
        lumaUI.homePage().validateHomePageExist();
    }

    @Test
    public void searchTest(){
        lumaUI.homePage().search("women watch");
        String actualTitle = lumaUI.searResultPage().getSearchResultPageTitle();
        Assert.assertTrue(actualTitle.contains("women watch"));
    }

    @Test
    public void selectTopNavBarItemTest(){
        List<String> myList = null;
        lumaUI.homePage().navBar().selectNavBarItem("Women>Tops>Tees");
        String actualTitle = lumaUI.searResultPage().getSearchResultPageTitle();
        Assert.assertEquals(actualTitle, "Tees");
    }

}

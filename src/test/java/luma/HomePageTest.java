package luma;

import com.magento.luma.WebDriverInitiate;
import com.magento.luma.pageController.LumaUIController;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {

    LumaUIController lumaUI = new LumaUIController();

    @BeforeClass
    public void init(){
        lumaUI.startApp();
    }

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

    }

}

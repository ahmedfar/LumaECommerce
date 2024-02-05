package luma;

import com.magento.lumaui.controller.LumaUIController;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LumaUIBaseTest {

    LumaUIController lumaUI = new LumaUIController();

    @BeforeClass
    public void init(){
        lumaUI.startApp();
    }


    @AfterClass
    public void traDown(){
        lumaUI.closeApp();
    }
}

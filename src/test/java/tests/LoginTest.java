package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLoginComSucesso(){

        new LoginPage(driver)
                .realizarLogin("van_eyck1@hotmail.com","123456");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

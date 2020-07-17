package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private static final String USER_BLOQUEADO = "Epic sadface: Sorry, this user has been locked out.";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLoginComUsuarioBloqueado(){
        String blocked = new LoginPage(driver)
                .realizarLogin("locked_out_user","secret_sauce")
                .capturarMensagemDeErro()
        ;

        assertEquals(USER_BLOQUEADO,blocked);
    }

    @Test
    public void testRealizarLoginComSucesso(){

        String labelProducts = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .labelProducts();

        assertEquals("Products", labelProducts);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

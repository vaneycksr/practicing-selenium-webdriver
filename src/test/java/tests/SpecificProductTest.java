package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class SpecificProductTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testValidarBotaoDeVoltar(){

        String tituloPaginaDeProdutos = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico("Sauce Labs Bike Light")
                .clicarBotaoVoltar()
                .tituloDaPaginaDeProdutos();

        assertEquals("Products",tituloPaginaDeProdutos);
    }
}

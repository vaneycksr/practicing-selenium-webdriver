package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class CheckoutStepOneTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testValidarClicarNoBotaoCancelar(){

        String tituloDaPagina = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .clicarNoBotaoCancelar()
                .retornaTituloDaPaginaDoCarrinhoDeCompras();

        assertEquals("Your Cart",tituloDaPagina);

    }

    @Test
    public void testValidarNaoPreencherOsCamposEClicarEmContinuar(){

        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();
        assertEquals("Error: First Name is required",msgErro);
    }

    @Test
    public void testValidarPrencherApenasCampoFirstName(){
        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .digitarFirstName("Van Eyck")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: Last Name is required",msgErro);
    }

    @Test
    public void testValidarPreencherApenasFirstNameELastName(){
        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .digitarFirstName("Van Eyck")
                .digitarLastName("Rosas")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: Postal Code is required",msgErro);
    }

    @Test
    public void testValidarPreencherApenasFirstNameEZipCode(){
        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Fleece Jacket")
                .clicarBotaoCheckout()
                .digitarFirstName("Van Eyck")
                .digitarZipCode("58225000")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: Last Name is required",msgErro);
    }

    @Test
    public void testValidarPrencherApenasCampoLastName(){

        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .digitarLastName("Rosas")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: First Name is required",msgErro);

    }

    @Test
    public void testValidarPreencherApenasLastNameEZipCode(){

        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .digitarLastName("Rosas")
                .digitarZipCode("58225000")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: First Name is required",msgErro);

    }

    @Test
    public void testValidarPrencherApenasCampoPostalCode(){
        String msgErro = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .digitarZipCode("58225000")
                .clicarBotaoContinuar()
                .retornaMsgDeErroStepOne();

        assertEquals("Error: First Name is required",msgErro);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

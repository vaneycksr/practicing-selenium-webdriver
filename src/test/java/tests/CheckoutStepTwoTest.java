package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

public class CheckoutStepTwoTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testVerificarBotarCancelar(){

        String tituloDaPaginaDeProdutos = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .preencherCamposCorretamente("Van Eyck","Rosas","58225000")
                .clicarNoBotaoCancelar()
                .tituloDaPaginaDeProdutos();

        assertEquals("Products",tituloDaPaginaDeProdutos);
    }

    @Test
    public void testVerificarFinalizarCompra(){

        String tituloDaPagina = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .clicarBotaoCheckout()
                .preencherCamposCorretamente("Van Eyck","Rosas","58225000")
                .clicarNoBotaoFinalizar()
                .retornaTituloDaPagina();

        assertEquals("Finish",tituloDaPagina);
    }

    @Test
    public void testVerificarFinalizarCompraSemNenhumProdutoNoCarrinho(){

        String totalDaCompra = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .preencherCamposCorretamente("Van Eyck","Rosas","58225000")
                .retornaTotalDaCompra();

        // TODO: 07/08/2020 como finalizar a compra??

        assertEquals("Total: $0.00", totalDaCompra);
    }

    @Test
    public void testVerificarFinalizarCompraComTodosOsProdutos(){
        String totalDaCompra = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Backpack")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Fleece Jacket")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Bolt T-Shirt")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Onesie")
                .adicionarProdutoNoCarrinhoDeCompras("Test.allTheThings() T-Shirt (Red)")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .preencherCamposCorretamente("Van Eyck","Rosas","58225000")
                .retornaTotalDaCompra();

        assertEquals("Total: $140.34", totalDaCompra);
    }

    @Test
    public void testVerificarSeProdutoColocadoNoCarrinhoEstaNoStepTwo(){

        boolean produtoEstarNoStepTwo = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Onesie")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .preencherCamposCorretamente("Van Eyck","Rosas","58225000")
                .verificarSeProdutoEstarNoStepTwo("Onesie");

        assertTrue(produtoEstarNoStepTwo);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

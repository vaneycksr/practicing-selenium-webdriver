package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

public class CartTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testVerificarBotaoDeContinuarComprando(){

        String tituloDaPagina = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarNoBotaoContinuarComprando()
                .tituloDaPaginaDeProdutos();

        assertEquals("Products",tituloDaPagina);
    }

    @Test
    public void testVerificarProdutoQueFoiAdicionadoAoCarrinho(){

        String produtoAdicionado = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Backpack")
                .getProdutoAdicionadoNoCarrinho();

        assertEquals("Sauce Labs Backpack", produtoAdicionado);
    }

    @Test
    public void testRemoverProdutoDoCarrinho(){

        boolean produtoEstaVisivel = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Bike Light")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras("Sauce Labs Backpack")
                .removerProduto("Sauce Labs Backpack")
                .botaoDoProdutoEstaVisivel("Sauce Labs Bike Light");

        assertTrue(produtoEstaVisivel);
    }

    @Test
    public void testVerificarClicarBotaoCheckout(){

        String tituloPaginaCheckout = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .retornaTituloDaPagina();


        assertEquals("Checkout: Your Information",tituloPaginaCheckout);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

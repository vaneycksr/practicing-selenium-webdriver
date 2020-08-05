package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class CartTest {

    private WebDriver driver;
    private static final String BACKPACK_ADD_REMOVE = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button";

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testValidarBotaoDeContinuarComprando(){

        String tituloDaPagina = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarNoBotaoContinuarComprando()
                .tituloDaPaginaDeProdutos();

        assertEquals("Products",tituloDaPagina);
    }

    @Test
    public void testValidarProdutoQueFoiAdicionadoAoCarrinho(){

        String produtoAdicionado = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras(BACKPACK_ADD_REMOVE)
                .getProdutoAdicionadoNoCarrinho();

        assertEquals("Sauce Labs Backpack", produtoAdicionado);
    }

    // TODO: 04/08/2020 Incompleto
    @Ignore
    public void testRemoverProdutoDoCarrinho(){

        new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras(BACKPACK_ADD_REMOVE);
    }

    @Test
    public void testValidarClicarBotaoCheckout(){

        String tituloPaginaCheckout = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .clicarBotaoCheckout()
                .retornaTituloDaPaginaCheckout();

        assertEquals("Checkout: Your Information",tituloPaginaCheckout);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

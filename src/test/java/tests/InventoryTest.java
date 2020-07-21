package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testClicarEmUmProdutoEspecifico(){

        String produto = "Sauce Labs Fleece Jacket";

        String tituloDoDetalheDoProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico(produto)
                .tituloDoProdutoClicado();

        assertEquals(produto,tituloDoDetalheDoProduto);
    }

    @Test
    public void testAdicionarProdutoNoCarrinhoDeCompras(){

        String qtdProdutosCarrinho = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras()
                .quantidadeDeProdutosNoCarrinho();
        assertEquals("1",qtdProdutosCarrinho);
    }



}

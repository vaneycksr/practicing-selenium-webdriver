package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.*;

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

    @Test
    public void testRemoveProdutoDoCarrinhoDeCompra(){

        String textoDoBotao = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .removerProdutoDocarrinhoDeCompras()
                .retornarTextoDoBotaoAdicionarRemoverDoCarrinho();

        assertEquals("ADD TO CART",textoDoBotao);
    }

    @Test
    public void testRealizarLogout(){

        boolean botaoVisivel = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmLogout()
                .botaoLoginVisivel();
        assertTrue(botaoVisivel);
    }

    @Test
    public void testValidarOrdenacaoDosProdutosZtoAUltimoProduto(){
        String ultimoProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutosZtoA()
                .getUltimoProdutoOrdenadoZtoA();
        assertEquals("Sauce Labs Backpack",ultimoProduto);
    }

    @Test
    public void testValidarOrdenacaoDosProdutosZtoAPrimeiroProduto(){
        String primeiroProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutosZtoA()
                .getUltimoPrimeiroOrdenadoZtoA();
        assertEquals("Test.allTheThings() T-Shirt (Red)",primeiroProduto);
    }

    @Ignore
    public void tearDown(){
        driver.quit();
    }


}

package tests;

import org.junit.After;
import org.junit.Before;
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

        String tituloDoDetalheDoProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico("Sauce Labs Fleece Jacket")
                .retornaTituloDoProdutoClicado();

        assertEquals("Sauce Labs Fleece Jacket",tituloDoDetalheDoProduto);
    }

    @Test
    public void testAdicionarProdutoNoCarrinhoDeCompras(){

        String qtdProdutosCarrinho = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Backpack")
                .quantidadeDeProdutosNoCarrinho();
        assertEquals("1",qtdProdutosCarrinho);
    }

    @Test
    public void testRemoveProdutoDoCarrinhoDeCompra(){

        String textoDoBotao = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .removerProdutoDoCarrinhoDeCompras("Sauce Labs Backpack")
                .retornarTextoDoBotaoAdicionarRemoverDoCarrinho();

        assertEquals("ADD TO CART",textoDoBotao);
    }

    @Test
    public void testRealizarLogout(){

        boolean botaoVisivel = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmLogout()
                .retornaBotaoLoginVisivel();
        assertTrue(botaoVisivel);
    }

    @Test
    public void testVerificarOrdenacaoDosProdutosZtoAUltimoProduto(){
        String ultimoProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutos("Name (Z to A)")
                .retornaUltimoProdutoPeloTitulo();
        assertEquals("Sauce Labs Backpack",ultimoProduto);
    }

    @Test
    public void testVerificarOrdenacaoDosProdutosZtoAPrimeiroProduto(){
        String primeiroProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutos("Name (Z to A)")
                .retornaPrimeiroProdutoPeloTitulo();
        assertEquals("Test.allTheThings() T-Shirt (Red)",primeiroProduto);
    }

    @Test
    public void testVerificarOrdenacaoPorMenorPreco(){

        String menorPreco = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutos("Price (low to high)")
                .retornaPrimeiroPrecoDoProduto();

        assertEquals("$7.99",menorPreco);
    }

    @Test
    public void testVerificarOrdenacaoPorMaiorPreco(){
        String maiorPreco = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarEmOrdenarProdutos("Price (high to low)")
                .retornaPrimeiroPrecoDoProduto();

        assertEquals("$49.99", maiorPreco);
    }

    @Test
    public void testVerificarOrdenacaoPorOrdemAlfabetica(){

        String primeiroProduto = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .retornaPrimeiroProdutoPeloTitulo();

        assertEquals("Sauce Labs Backpack",primeiroProduto);
    }

    @Test
    public void testVerificarClicarNoCarrinhoDeCompras(){
        String tituloDaPaginaDoCarrinhoDeCompras = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarNoCarrinhoDeCompras()
                .retornaTituloDaPagina();

        assertEquals("Your Cart",tituloDaPaginaDoCarrinhoDeCompras);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

package tests;

import org.junit.After;
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
    public void testVerificarBotaoDeVoltar(){

        String tituloPaginaDeProdutos = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico("Sauce Labs Bike Light")
                .clicarBotaoVoltar()
                .tituloDaPaginaDeProdutos();

        assertEquals("Products",tituloPaginaDeProdutos);
    }

    @Test
    public void testVerificarAdicionarAoCarrinhoNaPaginaEspecificaDoProduto(){
        String quantidadeNoCarrinho =  new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico("Sauce Labs Fleece Jacket")
                .clicarNoCarrinhoDeCompras()
                .quantidadeDeProdutosNoCarrinho();

        assertEquals("1",quantidadeNoCarrinho);
    }

    @Test
    public void testVerificarRemoverDoCarrinhoNaPaginaEspecificaDoProduto(){

        String textoDoBotao = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .clicarProdutoEspecifico("Sauce Labs Fleece Jacket")
                .clicarNoCarrinhoDeCompras()
                .clicarEmRemoverDoCarrinhoDeCompras()
                .retornaTextoDoBotaoAdicionarRemoverDoCarrinho();

        assertEquals("ADD TO CART",textoDoBotao);

    }

    @Test
    public void testVerificarJaTerProdutoNoCarrinhoEAdicionarUmProdutoPelaPaginaEspecifica(){

        String quantidadeNoCarrinho = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .adicionarProdutoNoCarrinhoDeCompras("Sauce Labs Backpack")
                .clicarProdutoEspecifico("Sauce Labs Fleece Jacket")
                .clicarNoCarrinhoDeCompras()
                .quantidadeDeProdutosNoCarrinho();

        assertEquals("2",quantidadeNoCarrinho);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

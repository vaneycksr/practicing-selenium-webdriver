package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private static final String MENSAGEM_DE_ERRO_LOGIN = "Problemas com o login do usuário";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLoginComEmailCorretoESenhaErrada(){

        String erroNoLogin = new LoginPage(driver)
                .realizarLogin("van_eyck1@hotmail.com","123455")
                .capturarMensagemDeErroNoLogin();
        assertEquals(MENSAGEM_DE_ERRO_LOGIN,erroNoLogin);
    }

    @Test
    public void testRealizarLoginComEmailErradoESenhaCorreta(){

        String erroNoLogin = new LoginPage(driver)
                .realizarLogin("vaneyck23@hotmail.com","123456")
                .capturarMensagemDeErroNoLogin();
        assertEquals(MENSAGEM_DE_ERRO_LOGIN,erroNoLogin);
    }

    @Test
    public void testRealizarLoginComCamposVazios(){

    }

    @Test
    public void testRealizarLoginComSucesso(){

        String mensagem = new LoginPage(driver)
                .realizarLogin("van_eyck1@hotmail.com","123456")
                .mensagemBemVindo();

        assertEquals("Bem vindo, van!", mensagem);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

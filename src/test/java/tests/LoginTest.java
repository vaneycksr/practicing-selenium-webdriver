package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private static final String LOCKED_USER = "Epic sadface: Sorry, this user has been locked out.";
    private static final String USERNAME_EMPTY = "Epic sadface: Username is required";
    private static final String PASSWORD_EMPTY = "Epic sadface: Password is required";
    private static final String INVALID_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.creatChrome();
    }

    @Test
    public void testRealizarLoginComUsuarioBloqueado(){
        String lockedUserMsgError = new LoginPage(driver)
                .realizarLogin("locked_out_user","secret_sauce")
                .capturarMensagemDeErro();

        assertEquals(LOCKED_USER,lockedUserMsgError);
    }

    @Test
    public void testRealizarLoginComUsuarioComProblema(){
        boolean imageProblemUser = new LoginPage(driver)
                .realizarLogin("problem_user","secret_sauce")
                .imagemComErro();

        assertEquals(false,imageProblemUser);

    }

    @Test
    public void testRealizarLoginComSucesso(){

        String labelProducts = new LoginPage(driver)
                .realizarLogin("standard_user","secret_sauce")
                .tituloDaPaginaDeProdutos();

        assertEquals("Products", labelProducts);
    }

    @Test
    public void testClicarNoBotaoDeLoginSemPreencherOsDoisCampos(){

        String errorMsg = new LoginPage(driver)
                .clicarBotaoLogin()
                .capturarMensagemDeErro();

        assertEquals(USERNAME_EMPTY, errorMsg);
    }

    @Test
    public void testPrencherUsernameCorretoEPasswordVazio(){

        String invalidPasswordMsg = new LoginPage(driver)
                .realizarLogin("standard_user","")
                .capturarMensagemDeErro();

        assertEquals(PASSWORD_EMPTY,invalidPasswordMsg);
    }

    @Test
    public void testPrencherUsernameVazioEPasswordCorreto(){

        String invalidUsernameMsg = new LoginPage(driver)
                .realizarLogin("","secret_sauce")
                .capturarMensagemDeErro();

        assertEquals(USERNAME_EMPTY,invalidUsernameMsg);
    }

    @Test
    public void testPreencherUsernameInvalidoEPasswordCorreto(){

        String invalidFieldsMsg = new LoginPage(driver)
                .realizarLogin("!@@#@#","secret_sauce")
                .capturarMensagemDeErro();

        assertEquals(INVALID_FIELDS,invalidFieldsMsg);

    }

    @Test
    public void testPreencherUsernameCorretoEPasswordInvalido(){

        String invalidFieldsMsg = new LoginPage(driver)
                .realizarLogin("standard_user","123456")
                .capturarMensagemDeErro();

        assertEquals(INVALID_FIELDS,invalidFieldsMsg);
    }

    // TODO: 18/07/2020 falta implementar esse teste de desempenho
    @Ignore
    public void testRealizarLoginComProblemaDePerformance(){

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

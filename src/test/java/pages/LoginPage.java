package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage digitarEmail(String email){

        driver.findElement(By.id("email")).sendKeys(email);

        return this;
    }

    public LoginPage digitarSenha(String password){

        driver.findElement(By.id("senha")).sendKeys(password);
        return this;
    }

    public HomePage clicarBotaoEntrar(){

        driver.findElement(By.xpath("//form/button")).click();

        return new HomePage(driver);
    }

    public HomePage realizarLogin(String email, String password){

        digitarEmail(email);
        digitarSenha(password);
        clicarBotaoEntrar();

        return new HomePage(driver);
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public boolean retornaBotaoLoginVisivel(){
        return driver.findElement(By.id("login-button")).isDisplayed();
    }

    public LoginPage digitarUsername(String email){

        driver.findElement(By.id("user-name")).sendKeys(email);

        return this;
    }

    public LoginPage digitarPassword(String password){

        driver.findElement(By.id("password")).sendKeys(password);

        return this;
    }

    public InventoryPage clicarBotaoLogin(){

        driver.findElement(By.cssSelector("input[id='login-button']")).click();

        return new InventoryPage(driver);
    }

    public InventoryPage realizarLogin(String user, String password){

        digitarUsername(user);
        digitarPassword(password);
        clicarBotaoLogin();

        return new InventoryPage(driver);
    }




}

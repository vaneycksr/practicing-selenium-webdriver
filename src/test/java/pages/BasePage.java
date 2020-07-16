package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public String capturarMensagemDeErroNoLogin(){
         return driver.findElement(By.cssSelector("div[class$=danger")).getText();
    }

}

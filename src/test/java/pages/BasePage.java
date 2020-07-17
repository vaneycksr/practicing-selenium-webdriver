package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    public String capturarMensagemDeErro(){

        return driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/h3")).getText();
    }

}

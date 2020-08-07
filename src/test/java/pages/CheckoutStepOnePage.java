package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public String retornaTituloDaPaginaCheckout(){
        return driver.findElement(By.xpath("//div[@class='subheader']")).getText();
    }

    public CartPage clicarNoBotaoCancelar(){

        driver.findElement(By.linkText("CANCEL")).click();

        return new CartPage(driver);
    }

    public CheckoutStepTwoPage clicarBotaoContinuar(){

        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();

        return new CheckoutStepTwoPage(driver);
    }

    public CheckoutStepOnePage digitarFirstName(String firstName){

        driver.findElement(By.id("first-name")).sendKeys(firstName);

        return this;
    }

    public CheckoutStepOnePage digitarLastName(String lastName){

        driver.findElement(By.id("last-name")).sendKeys(lastName);

        return this;
    }

    public CheckoutStepOnePage digitarZipCode(String zipCode){

        driver.findElement(By.id("postal-code")).sendKeys(zipCode);

        return this;
    }

}

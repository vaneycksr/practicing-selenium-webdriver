package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String retornaTituloDaPaginaCheckout(){
        return driver.findElement(By.xpath("//div[@class='subheader']")).getText();
    }
}

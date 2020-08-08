package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage clicarNoBotaoCancelar(){

        driver.findElement(By.linkText("CANCEL")).click();

        return new InventoryPage(driver);
    }

    public CheckoutCompletePage clicarNoBotaoFinalizar(){

        driver.findElement(By.linkText("FINISH")).click();

        return new CheckoutCompletePage(driver);
    }

    public String retornaTotalDaCompra(){

        return driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
    }

}

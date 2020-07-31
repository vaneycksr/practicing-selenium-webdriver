package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String retornaTituloDaPaginaDoCarrinhoDeCompras(){
        return driver.findElement(By.xpath("//div[@class='subheader']")).getText();
    }

    public InventoryPage clicarNoBotaoContinuarComprando(){

        driver.findElement(By.linkText("CONTINUE SHOPPING")).click();

        return new InventoryPage(driver);
    }

    public String getProdutoAdicionadoNoCarrinho(){

        return driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();

    }

}

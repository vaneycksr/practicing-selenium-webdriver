package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecificProductPage extends BasePage{
    public SpecificProductPage(WebDriver driver) {
        super(driver);
    }

    public String tituloDoProdutoClicado(){

        return driver.findElement(By.xpath("//div[@class='inventory_details_name']")).getText();

    }

    public InventoryPage clicarBotaoVoltar(){

        driver.findElement(By.xpath("//button[@class='inventory_details_back_button']")).click();

        return new InventoryPage(driver);
    }

    public SpecificProductPage clicarNoCarrinhoDeCompras(){

        driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();

        return this;
    }

    public SpecificProductPage clicarEmRemoverDoCarrinhoDeCompras(){

        driver.findElement(By.xpath("//button[@class='btn_secondary btn_inventory']")).click();

        return this;
    }

    public String getTextoDoBotaoAdicionarRemoverDoCarrinho(){

        return driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button")).getText();
    }

}

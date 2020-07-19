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


}

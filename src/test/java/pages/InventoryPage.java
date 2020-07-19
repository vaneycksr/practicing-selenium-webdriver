package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String labelProducts(){
        return driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div")).getText();
    }

    // verifica se uma imagem está na página
    public boolean imgWithError(){

        WebElement ImageFile = driver.findElement(By.xpath("//*[@id=\"item_2_img_link\"]/img"));

        /*
        *
        * The next line executes some javascript and returns the result to ImagePresent.
        *
        * The Javascript checks if image (arguments[0]) has completed loading AND its naturalWidth is not "undefined" AND its naturalWidth is greater than zero.
        *
        * In other words, it checks if it is loaded AND wider than nothing :)
        *
        * */
        return (Boolean) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
    }


}

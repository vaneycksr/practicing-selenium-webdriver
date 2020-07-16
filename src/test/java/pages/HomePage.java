package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String mensagemBemVindo(){
        return driver.findElement(By.cssSelector("div[class^=alert]")).getText();
    }


}

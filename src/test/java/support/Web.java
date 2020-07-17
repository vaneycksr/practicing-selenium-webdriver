package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver creatChrome(){

        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        // definir tempo padrão de espera
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        return driver;

    }

}

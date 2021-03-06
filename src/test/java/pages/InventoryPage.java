package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String tituloDaPaginaDeProdutos(){
        return driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div")).getText();
    }

    // verifica se uma imagem está na página
    public boolean imagemComErro(){

        WebElement ImageFile = driver.findElement(By.xpath("//*[@id=\"item_2_img_link\"]/img"));

        /*
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

    public SpecificProductPage clicarProdutoEspecifico(String product){

        driver.findElement(By.xpath("//div[contains(text(),'"+product+"')]")).click();

        return new SpecificProductPage(driver);

    }

    public String retornarTextoDoBotaoAdicionarRemoverDoCarrinho(){

        return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).getText();
    }

    public InventoryPage adicionarProdutoNoCarrinhoDeCompras(String productName){

        driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/../../../div[3]/button")).click();

        return this;
    }

    public InventoryPage removerProdutoDoCarrinhoDeCompras(String xpathDoProduto){

        adicionarProdutoNoCarrinhoDeCompras(xpathDoProduto);

        driver.findElement(By.xpath("//div[contains(text(),'"+xpathDoProduto+"')]/../../../div[3]/button")).click();

        return this;
    }

    public InventoryPage clicarNoMenu(){

        driver.findElement(By.className("bm-burger-button")).click();

        return this;
    }

    public CartPage clicarNoCarrinhoDeCompras(){

        driver.findElement(By.xpath("//a[@href='./cart.html']")).click();

        return new CartPage(driver);
    }

    public CartPage adicionaProdutoAoCarrinhoEClicaNoCarrinhoDeCompras(String xpathDoProduto){

        adicionarProdutoNoCarrinhoDeCompras(xpathDoProduto);
        clicarNoCarrinhoDeCompras();

        return new CartPage(driver);
    }

    public LoginPage clicarEmLogout(){

        clicarNoMenu();
        driver.findElement(By.linkText("Logout")).click();

        return new LoginPage(driver);
    }

    public InventoryPage clicarEmOrdenarProdutos(String orderType){

        WebElement campoType = driver.findElement(By.className("product_sort_container"));
        new Select(campoType).selectByVisibleText(orderType);

        return this;
    }

    public String retornaUltimoProdutoPeloTitulo(){

        return driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[last()]")).getText();
    }

    public String retornaPrimeiroProdutoPeloTitulo(){

        return driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
    }

    public String retornaPrimeiroPrecoDoProduto(){
        return driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
    }


}

package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GHomePage {
    WebDriver driver;
    public GHomePage(WebDriver driver){
        this.driver=driver;
    }

    protected By acceptCookies = By.cssSelector(".btn.primary");
    protected By products=By.cssSelector(".main-navigation.clear.noselect>div>div .megabtn >div");
    protected By mobilniTelefoniIOprema=By.cssSelector(".items  #main-nav-7");

    public void accCookies(){
        driver.findElement(acceptCookies).click();
    }
    public void selectProductsMenu(){
        driver.findElement(products).click();
    }
    public void selectItemFromMenu(){
        driver.findElement(mobilniTelefoniIOprema).click();
    }

    public void navigateToMobilniTelefoniIOprema(){
        accCookies();
        selectProductsMenu();
        selectItemFromMenu();
    }

}

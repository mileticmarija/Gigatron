package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GMobilniTelefoniIOpremaPage {
    WebDriver driver;
    public GMobilniTelefoniIOpremaPage(WebDriver driver){
        this.driver=driver;
    }

    protected By mobilniTelefoni= By.cssSelector(".category_menu .row>div:nth-child(1) .innerIWPC .catmenu-main a");

    public void navigateToMobilniTelefoni(){
        driver.findElement(mobilniTelefoni).click();
    }

    public void checkPage(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}

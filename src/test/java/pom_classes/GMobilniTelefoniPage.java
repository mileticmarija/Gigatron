package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GMobilniTelefoniPage {
    WebDriver driver;
    public GMobilniTelefoniPage(WebDriver driver){
        this.driver=driver;
    }

    //protected By item1= By.cssSelector(".row.product-items-main.view-grid>div:nth-child(1) .product-header>span");
    //protected By item2= By.cssSelector(".row.product-items-main.view-grid>div:nth-child(2) .product-header>span");
    protected By compare=By.cssSelector(".compare-widget>div>a");


    public void selectItems(String ... item) throws InterruptedException {
      //driver.findElement(item1).click();
      //driver.findElement(item2).click();
        for(int i=0;i<item.length;i++) {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".row.product-items-main.view-grid>div:nth-child("+item[i]+") .product-header>span")).click();
        }
    }

    public void checkPage(String url2){
        Assert.assertEquals(driver.getCurrentUrl(),url2);
    }

    public void navigateToComparePage(){
        driver.findElement(compare).click();
    }
}

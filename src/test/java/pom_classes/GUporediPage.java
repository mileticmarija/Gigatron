package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GUporediPage {
    WebDriver driver;
    public GUporediPage(WebDriver driver){
        this.driver=driver;
    }

    protected By compareBtn=By.cssSelector(".compare-group-items-footer.clear>a");
    protected By dijagonalaEkrana1 = By.cssSelector(".compare-table>tbody>tr:nth-child(1)>td:nth-child(1)>span:last-child");
    protected By dijagonalaEkrana2 = By.cssSelector(".compare-table>tbody>tr:nth-child(1)>td:nth-child(2)>span:last-child");

    public void checkPage(String url3){
        Assert.assertEquals(driver.getCurrentUrl(),url3);
    }

    public void compare(){
        driver.findElement(compareBtn).click();

        String d1 = driver.findElement(dijagonalaEkrana1).getText();
        String d2 = driver.findElement(dijagonalaEkrana2).getText();
        if(!d1.equals(d2)){
            System.out.println("Razlika u dijagonali ekrana, D1: "+d1+" D2: "+d2);
        }
    }
}

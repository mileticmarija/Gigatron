package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterGigatronPage {
    WebDriver driver;
    public RegisterGigatronPage(WebDriver driver){
        this.driver=driver;
    }

    protected By cookie= By.cssSelector("#gdpr-cookie-settings .btn.primary");
    protected By emailBox=By.cssSelector("#email");
    protected By passBox=By.cssSelector("#password");
    protected By newsCheckBox=By.cssSelector("#newsletter");
    protected By aggrementBox=By.cssSelector("#aggrement");
    protected By registerButton=By.cssSelector("#loginSubmit");
    protected By messageBox=By.cssSelector(".login-box");

    public void acceptCookies(){
        driver.findElement(cookie).click();
    }
    public void enterEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }
    public void enterPass (String pass){
        driver.findElement(passBox).sendKeys(pass);
    }
    public void selectNewsLetter(){
        driver.findElement(newsCheckBox).click();
    }
    public void selectAggrement(){
        driver.findElement(aggrementBox).click();
    }
    public void submitData(){
        driver.findElement(registerButton).click();
    }

    public void enterData(String email, String pass){
        enterEmail(email);
        enterPass(pass);
    }

    public void selectAll(){
        selectNewsLetter();
        selectAggrement();
    }

    public void register(String email, String pass){
        acceptCookies();
        enterData(email,pass);
        selectAll();
        submitData();
    }

    public void registerWithoutSelect(String email, String pass){
        acceptCookies();
        enterData(email,pass);
        submitData();
    }

    public void checkMessage(String message){
        Assert.assertEquals(driver.findElement(messageBox).getText(),message);
    }
}

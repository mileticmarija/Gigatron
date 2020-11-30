package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.RegisterGigatronPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;
@Listeners (allure.AllureListener.class)
public class RegistrationGigatronTest {
    WebDriver driver;
    String URL="https://gigatron.rs/registracija";
    DriverManager driverManager;
    RegisterGigatronPage rgp;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser){
        driverManager= DriverManagerFactory.getDriverManager(browser);
        driver=driverManager.qetWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Parameters({"email","pass"})
    public void registerGigatron(String email, String pass){
        rgp=new RegisterGigatronPage(driver);

        rgp.register(email,pass);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }

}

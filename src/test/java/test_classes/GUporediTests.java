package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.GHomePage;
import pom_classes.GMobilniTelefoniIOpremaPage;
import pom_classes.GMobilniTelefoniPage;
import pom_classes.GUporediPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

@Listeners(allure.AllureListener.class)
public class GUporediTests {
    WebDriver driver;
    String URL="https://gigatron.rs/";
    DriverManager driverManager;
    GHomePage ghp;
    GMobilniTelefoniIOpremaPage gmtiop;
    GMobilniTelefoniPage gmtp;
    GUporediPage gup;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser){
        driverManager= DriverManagerFactory.getDriverManager(browser);
        driver=driverManager.qetWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Parameters({"url", "url2","url3","item1","item2"})
    @Test
    public void comparePhones(String url,String url2, String url3, String item1,String item2) throws InterruptedException {
        ghp=new GHomePage(driver);
        ghp.navigateToMobilniTelefoniIOprema();

        gmtiop=new GMobilniTelefoniIOpremaPage(driver);
        gmtiop.checkPage(url);
        gmtiop.navigateToMobilniTelefoni();

        gmtp=new GMobilniTelefoniPage(driver);
        gmtp.checkPage(url2);
        gmtp.selectItems(item1,item2);
        gmtp.navigateToComparePage();

        gup=new GUporediPage(driver);
        gup.checkPage(url3);
        gup.compare();

    }


    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }

}

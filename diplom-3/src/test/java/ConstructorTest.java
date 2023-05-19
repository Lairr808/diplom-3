import Pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ConstructorTest {
    private WebDriver driver;


    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkSectionSaucesButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.saucesSectionCLick();
    }

    @Test
    public void checkSectionFillingButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.fillingSectionCLick();
    }

    @Test
    public void checkSectionBunsButton(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.bunsSectionCLick();
    }
}

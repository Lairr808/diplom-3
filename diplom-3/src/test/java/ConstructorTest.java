import Pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    private WebDriver driver;


    @Before
    public void startDriver() {
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
    public void checkSectionSaucesButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.saucesSectionCLick();
        assertEquals("Соусы", objMainPage.checkTabSection());
    }

    @Test
    public void checkSectionFillingButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.fillingSectionCLick();
        assertEquals("Начинки", objMainPage.checkTabSection());
    }

    @Test
    public void checkSectionBunsButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.fillingSectionCLick();
        objMainPage.bunsSectionCLick();
        assertEquals("Булки", objMainPage.checkTabSection());
    }
}


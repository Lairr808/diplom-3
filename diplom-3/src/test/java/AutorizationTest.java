import Pages.*;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AutorizationTest {
    private WebDriver driver;
    private String accessToken;
    private User user = User.getDefault();

    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        CreateUser.create(user);//создай
        ValidatableResponse loginResponse = CreateUser.login(CredentialsUser.from(user));//авторизация
        accessToken = loginResponse.extract().path("accessToken");//тащит токен
    }

    @After
    public void teardown() {
        driver.quit();
        if (accessToken == null) return;
        CreateUser.delete(accessToken);
    }

    @Test
    public void checkAutorizationButtonInMainPage(){
        MainPage objMainPage = new MainPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objMainPage.enterButtonCLick();
        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);

    }

    @Test
    public void checkProfileButtonInMainPage(){
        MainPage objMainPage = new MainPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objMainPage.profileButtonCLick();
        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);
    }

    @Test
    public void checkAutorizationButtonInRegisterPage(){
        RegisterPage objRegisterPage = new RegisterPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        MainPage objMainPage = new MainPage(driver);

        objMainPage.enterButtonCLick();
        objAuthorizationPage.registerButtonCLick();
        objRegisterPage.enterButtonCLick();

        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);
    }

    @Test
    public void checkAutorizationButtonInPasswordRecoveryPage(){
        PasswordRecoveryPage objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        MainPage objMainPage = new MainPage(driver);

        objMainPage.enterButtonCLick();
        objAuthorizationPage.passwordRecoveryButtonCLick();
        objPasswordRecoveryPage.enterButtonCLick();

        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);
    }

}

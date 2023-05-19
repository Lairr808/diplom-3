import Pages.*;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static Pages.RegisterPage.BASE_URI;
import static org.junit.Assert.assertEquals;

public class RegisterTest {
    private WebDriver driver;
    private User user = User.getDefault();
    private String accessToken;

    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
        RestAssured.baseURI = BASE_URI;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        ValidatableResponse loginResponse = CreateUser.login(CredentialsUser.from(user));//авторизация
        accessToken = loginResponse.extract().path("accessToken");//тащит токен
    }

    @After
    public void teardown() {
        if (accessToken == null) return;
        CreateUser.delete(accessToken);
        driver.quit();
    }

    @Test
    public void checkUserRegistrationCorrect(){
        MainPage objMainPage = new MainPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objMainPage.enterButtonCLick();
        objAuthorizationPage.registerButtonCLick();

        objRegisterPage.nameField(user.getName());
        objRegisterPage.passwordField(user.getPassword());
        objRegisterPage.emailField(user.getEmail());
        objRegisterPage.registerButtonCLick();

        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);
    }

    @Test
    public void checkUserRegistrationError(){
        MainPage objMainPage = new MainPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objMainPage.enterButtonCLick();
        objAuthorizationPage.registerButtonCLick();

        objRegisterPage.nameField(user.getName());
        objRegisterPage.passwordField("f6f7f");
        objRegisterPage.emailField(user.getEmail());
        objRegisterPage.registerButtonCLick();

        String headerWindow = objRegisterPage.headerWindow();
        assertEquals("Некорректный пароль", headerWindow);

    }
}

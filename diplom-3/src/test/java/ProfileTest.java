import Pages.*;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ProfileTest {
    private WebDriver driver;
    private String accessToken;
    private User user = User.getDefault();
    private CredentialsUser credentialsUser = CredentialsUser.getDefault();



    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ValidatableResponse response = CreateUser.create(user);//создаq
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
    public void checkConstructorButton(){
        MainPage objMainPage = new MainPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);

        objMainPage.profileButtonCLick();
        objAuthorizationPage.emailField(credentialsUser.getEmail());
        objAuthorizationPage.passwordField(user.getPassword());
        objAuthorizationPage.enterButtonCLick();
        objMainPage.profileButtonCLick();
        objProfilePage.constructorButtonCLick();

        String headerWindow = objMainPage.headerWindow();
        assertEquals("Соберите бургер", headerWindow);
    }

    @Test
    public void checkLogoButton(){
        MainPage objMainPage = new MainPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);

        objMainPage.profileButtonCLick();
        objAuthorizationPage.emailField(credentialsUser.getEmail());
        objAuthorizationPage.passwordField(user.getPassword());
        objAuthorizationPage.enterButtonCLick();
        objMainPage.profileButtonCLick();
        objProfilePage.logoStellarBurgersButtonCLick();

        String headerWindow = objMainPage.headerWindow();
        assertEquals("Соберите бургер", headerWindow);
    }

    @Test
    public void checkOutButton(){
        MainPage objMainPage = new MainPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);

        objMainPage.profileButtonCLick();
        objAuthorizationPage.emailField(credentialsUser.getEmail());
        objAuthorizationPage.passwordField(user.getPassword());
        objAuthorizationPage.enterButtonCLick();
        objMainPage.profileButtonCLick();
        objProfilePage.outButtonCLick();

        String headerWindow = objAuthorizationPage.headerWindow();
        assertEquals("Вход", headerWindow);
    }
}

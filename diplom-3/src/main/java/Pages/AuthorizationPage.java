package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage {
    private WebDriver driver;
    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    //поле Email"
    private final By fieldEmail = By.xpath("//fieldset[1]/div/div/input");

    //поле Пароль
    private final By fieldPassword = By.xpath("//fieldset[2]/div/div/input");

    //Кнопка Войти
    private final By buttonEnter = By.xpath("html/body/div/div/main/div/form/button[text()='Войти']");

    //кнопка Зарегестрироваться
    private final By buttonRegister = By.xpath("html/body/div/div/main/div/div/p/a[text()='Зарегистрироваться']");
    //кнопка Востановить пароль
    private final By buttonPasswordRecovery = By.xpath("html/body/div/div/main/div/div/p/a[text()='Восстановить пароль']");

    public void emailField(String email) { driver.findElement(fieldEmail).sendKeys(email); }
    public void passwordField(String password) { driver.findElement(fieldPassword).sendKeys(password); }
    public void enterButtonCLick() {driver.findElement(buttonEnter).click();}
    public void registerButtonCLick() {driver.findElement(buttonRegister).click();}
    public void passwordRecoveryButtonCLick() {driver.findElement(buttonPasswordRecovery).click();}

    public String headerWindow(){
        return driver.findElement(By.xpath("html/body/div/div/main/div/h2[text()='Вход']")).getText();
    }

    //public void enter( String email, String password){
    //    emailField(email);
    //    passwordField(password);
    //    enterButtonCLick();
    //}



}

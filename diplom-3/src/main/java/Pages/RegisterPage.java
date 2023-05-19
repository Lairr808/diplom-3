package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    //поле имя
    private final By fieldName = By.xpath("//fieldset[1]/div/div/input");
    //поле Email
    private final By fieldEmail = By.xpath("//fieldset[2]/div/div/input");
    //поле пароль
    private final By fieldPassword = By.xpath("//fieldset[3]/div/div/input");
    //кнопка зарегестрироваться
    private final By buttonRegister = By.xpath("html/body/div/div/main/div/form/button[text()='Зарегистрироваться']");
    //кнопка "Войти"
    private final By buttonEnter = By.xpath("html/body/div/div/main/div/div/p/a[text()='Войти']");

    public void nameField(String name) { driver.findElement(fieldName).sendKeys(name); }
    public void emailField(String email) { driver.findElement(fieldEmail).sendKeys(email); }
    public void passwordField(String password) { driver.findElement(fieldPassword).sendKeys(password); }
    public void registerButtonCLick() {driver.findElement(buttonRegister).click();}
    public void enterButtonCLick() {driver.findElement(buttonEnter).click();}

    public String headerWindow(){
        return driver.findElement(By.xpath("html/body/div/div/main/div/form/fieldset/div/p[text()='Некорректный пароль']")).getText();
    }

   // public void register(String name, String email, String password){
    //    nameField(name);
   //     emailField(email);
   //     passwordField(password);
    //    registerButtonCLick();
    //}

}

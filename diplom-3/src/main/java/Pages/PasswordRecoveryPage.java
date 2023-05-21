package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Войти
    private final By buttonEnter = By.xpath("html/body/div/div/main/div/div/p/a[text()='Войти']");

    public void enterButtonCLick() {driver.findElement(buttonEnter).click();}

}

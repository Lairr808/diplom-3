package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //клик Конструктор
    private final By buttonConstructor = By.xpath("html/body/div/div/header/nav/ul/li/a/p[text()='Конструктор']");

    //клик логотип Stellar Burgers
    private final By buttonLogoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");

    //кнопка Выйти
    private final By buttonOut = By.xpath("html/body/div/div/main/div/nav/ul/li/button[text()='Выход']");

    public void constructorButtonCLick() {driver.findElement(buttonConstructor).click();}
    public void logoStellarBurgersButtonCLick() {driver.findElement(buttonLogoStellarBurgers).click();}
    public void outButtonCLick() {driver.findElement(buttonOut).click();}




}

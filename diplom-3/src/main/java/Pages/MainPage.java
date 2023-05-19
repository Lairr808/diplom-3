package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка Войти в аккаунт
    private final By buttonEnter = By.xpath("html/body/div/div/main/section/div/button[text()='Войти в аккаунт']");

    //кнопка Личный кабинет
    private final By buttonProfile = By.xpath("html/body/div/div/header/nav/a/p[text()='Личный Кабинет']");

    //раздел "Булки"
    private final By sectionBuns = By.xpath("html/body/div/div/main/section/div/div/span[text()='Булки']");

    //раздел "Соусы"
    private final By sectionSauces = By.xpath("html/body/div/div/main/section/div/div/span[text()='Соусы']");

    //раздел "Начинки"
    private final By sectionFilling = By.xpath("html/body/div/div/main/section/div/div/span[text()='Начинки']");

    public void enterButtonCLick() {driver.findElement(buttonEnter).click();}
    public void profileButtonCLick() {driver.findElement(buttonProfile).click();}
    public void bunsSectionCLick() {driver.findElement(sectionBuns).click();}
    public void saucesSectionCLick() {driver.findElement(sectionSauces).click();}
    public void fillingSectionCLick() {driver.findElement(sectionFilling).click();}

    public String headerWindow(){
        return driver.findElement(By.xpath("html/body/div/div/main/section/h1[text()='Соберите бургер']")).getText();
    }


}

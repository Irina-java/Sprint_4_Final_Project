package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Первый вопрос в блоке "Воросы о важном"
    private By questionByIndex(int  index) {
        return By.id("accordion__heading-"  +  index);
    }

    // Ответ на первый вопрос
    private By answerByIndex(int index) {
        return By.id("accordion__panel-" + index);
    }

    // Логотип "Самокат"
    private By scooterLogo = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]");

    // Логотип "Яндекс"
    private By yandexLogo = By.xpath(".//a[contains(@class, 'Header_LogoYandex')]");

    // Несуществующий номер заказа
    // Кнопка "Статус заказа"
    private By orderStatusButton = By.xpath(".//button[text()= 'Статус заказа']");

    // Поле ввода номера заказа
    private By orderNumberField  = By.xpath(".//input[@placeholder= 'Введите номер заказа']");

    // Кнопка "Go!"
    private By goButton = By.xpath(".//button[contains(text(), 'Go')]");

    // Сообщение "Такого заказа нет"
    private By  orderNotFoundMessage = By.xpath(".//div[contains(@class, 'Track_NotFound')]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void scrollToQuestion(int index) {
        WebElement element = driver.findElement(questionByIndex(index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    }

    public void clickQuestion(int index) {
        driver.findElement(questionByIndex(index)).click();
    }

    public String getAnswerText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerByIndex(index)));
        return driver.findElement(answerByIndex(index)).getText();
    }

    // Логотип "Самокат"
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    // Логотип "Яндекс"
    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }
    public String getYandexLogoLink() {
        return driver.findElement(yandexLogo).getAttribute("href");
    }

    // Несуществующий номер заказа
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }
    public void setOrderNumber(String orderNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberField));
        driver.findElement(orderNumberField).sendKeys(orderNumber);
    }
    public void clickGoButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(goButton));
        driver.findElement(goButton).click();
    }
    public boolean isOrderNotFoundMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNotFoundMessage));
        return driver.findElement(orderNotFoundMessage).isDisplayed();
    }
}
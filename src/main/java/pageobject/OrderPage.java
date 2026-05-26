package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class OrderPage {
    private WebDriver driver;


    // Верхняя кнопка "Заказать" на главной странице "
    private By topOrderButton = By.xpath(".//button[text()='Заказать']");

    // Первая Форма заказа
    // Поле "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private By metroStationField = By.xpath(".//input[@placeholder= '* Станция метро']");

    // Поле "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder= '* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");

    // Вторая форма заказа
    // Поле "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder= '* Когда привезти самокат']");

    // Поле "Срок аренды"
    private By rentalPeriodField = By.xpath(".//div[@class= 'Dropdown-placeholder']");

    // Поле "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder= 'Комментарий для курьера']");

    // Кнопка "Заказать" в форме
    private By orderButtonInform = By.xpath(".//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");

    // Кнопка "Да" в окне подтверждения заказа
    private By yesButton = By.xpath(".//button[text()= 'Да']");

    // Сообщение об успешном создании заказа
    private By orderSuccessMessage = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    // Нижняя кнопка "Заказать" на главной странице "

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ошибки полей первой формы заказа
    // Ошибка поля "Имя"
    private By nameError = By.xpath(".//div[text()= 'Введите корректное имя']");

    // Ошибка поля "Фамилия"
    private By surnameError = By.xpath(".//div[text()= 'Введите корректную фамилию']");

    // Ошибка поля "Адрес"
    private By addressError = By.xpath(".//div[text()= 'Введите корректный адрес']");

    // Ошибка поля "Метро"
    private By metroError = By.xpath(".//div[text()= 'Выберите станцию']");

    // Ошибка поля "Телефон"
    private By phoneError = By.xpath(".//div[text()= 'Выберите корректный номер']");

    // Первая форма заказа (верхняя кнопка "Заказать")
    private By bottomOrderButton = By.xpath("(//button[text()='Заказать'])[2]");


    public void clickTopOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(topOrderButton));
        driver.findElement(topOrderButton).click();
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void setMetroStation(String stationName) {
        driver.findElement(metroStationField).sendKeys(stationName);
        driver.findElement(By.xpath(".//div[text()= '"+ stationName +"']")).click();
    }
    public void setPhone( String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
public void fillFirstOrderPage(String name, String surname, String address, String metroStation, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStation);
        setPhone(phone);
}

// Ошибки полей первой формы заказа
    public boolean isNameErrorDisplayed() {
        return driver.findElement(nameError).isDisplayed();
    }
    public boolean isSurnameErrorDisplayed() {
        return driver.findElement(nameError).isDisplayed();
    }
    public boolean isAddressErrorDisplayed() {
        return driver.findElement(nameError).isDisplayed();
    }
    public boolean isMetroErrorDisplayed() {
        return driver.findElement(nameError).isDisplayed();
    }
    public boolean isPhoneErrorDisplayed() {
        return driver.findElement(nameError).isDisplayed();
    }

    // Вторая форма заказа (верхняя кнопка "Заказать")
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }
    public void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }
    public void selectScooterColor(String color) {
        driver.findElement(By.xpath(".//label[text()='" + color + "']")).click();
    }
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButtonInForm() {
        driver.findElement(orderButtonInform).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public boolean isOrderSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMessage));
        return driver.findElement(orderSuccessMessage).isDisplayed();
    }
 public void fillSecondOrderPage(String date, String rentalPeriod,String color, String comment) {
        setDate(date);
        clickRentalPeriodField();
        selectRentalPeriod(rentalPeriod);
        selectScooterColor(color);
        setComment(comment);
 }
 public void scrollToBottomOrderButton() {
        WebElement element = driver.findElement(bottomOrderButton);
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
 }
 public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
 }

}

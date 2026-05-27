package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class OrderTest {
    private final boolean useTopButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(boolean useTopButton, String name, String surname, String address, String metroStation, String phone, String date, String rentalPeriod, String color, String comment) {
        this.useTopButton = useTopButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Заказ: кнопка={0}, имя={1}, фамилия={2}")
    public static Collection<Object[]>getOrderData() {
        return Arrays.asList(new Object[][] {
                {true, "Ирина", "Иванова", "Москва, Ленина, 1", "Комсомольская", "+79997778844", "26.05.2026", "сутки", "чёрный жемчуг", "Позвонить за час"},
                {false, "Алексей", "Алешин", "Москва, Цветочная, 13", "Сокольники", "+79557728164", "27.05.2026", "двое суток", "серая безысходность", "Оставить у подъезда"}
        });
    }
    @Test
    public void createOrderTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.openPage();

        if (useTopButton) {
            orderPage.clickTopOrderButton();
        } else {
            orderPage.scrollToBottomOrderButton();
            orderPage.clickBottomOrderButton();
        }

        orderPage.fillFirstOrderPage(name, surname, address, metroStation, phone);
        orderPage.clickNextButton();

        orderPage.fillSecondOrderPage(date, rentalPeriod, color, comment);
        orderPage.clickOrderButtonInForm();
        orderPage.clickYesButton();

        assertTrue(orderPage.isOrderSuccessMessageDisplayed());

        driver.quit();
    }
}

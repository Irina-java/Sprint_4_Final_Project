package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import static org.junit.Assert.assertTrue;

public class OrderFieldsErrorsTest {

    @Test
    public void emptyFirstOrderPageShowsErrorsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.openPage();

        orderPage.clickTopOrderButton();
        orderPage.clickNextButton();

        assertTrue(orderPage.isNameErrorDisplayed());
        assertTrue(orderPage.isSurnameErrorDisplayed());
        assertTrue(orderPage.isAddressErrorDisplayed());
        assertTrue(orderPage.isMetroErrorDisplayed());
        assertTrue(orderPage.isPhoneErrorDisplayed());

        driver.quit();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import org.junit.After;
import static org.junit.Assert.assertTrue;

public class OrderFieldsErrorsTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    private void openOrderPageAndClickNext() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);

        mainPage.openPage();
        orderPage.clickTopOrderButton();
        orderPage.clickNextButton();
    }

@Test
public void emptyNameShowsErrorTest() {
    openOrderPageAndClickNext();
    assertTrue(orderPage.isNameErrorDisplayed());
}

@Test
    public void emptySurnameShowsErrorTest() {
        openOrderPageAndClickNext();
        assertTrue(orderPage.isSurnameErrorDisplayed());
    }

    @Test
    public void emptyAddressShowsErrorTest() {
        openOrderPageAndClickNext();
        assertTrue(orderPage.isAddressErrorDisplayed());
    }

    @Test
    public void emptyMetroShowsErrorTest() {
        openOrderPageAndClickNext();
        assertTrue(orderPage.isMetroErrorDisplayed());
    }

    @Test
    public void emptyPhoneShowsErrorTest() {
        openOrderPageAndClickNext();
        assertTrue(orderPage.isPhoneErrorDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

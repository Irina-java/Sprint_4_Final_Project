package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import static org.junit.Assert.assertTrue;
import org.junit.After;

public class OrderStatusTest {
    private WebDriver driver;

    @Test
    public void nonexistentOrderShowsNotFoundMessageTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        mainPage.clickOrderStatusButton();
        mainPage.setOrderNumber("000000");
        mainPage.clickGoButton();

        assertTrue(mainPage.isOrderNotFoundMessageDisplayed());
    }
    @After
    public void tearDown()  {
        driver.quit();
    }
}

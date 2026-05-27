package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;

public class LogoTest {
private WebDriver driver;
    @Test
    public void scooterLogoOpensMainPageTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();

        mainPage.clickScooterLogo();

        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

    }

    @Test
    public void  yandexLogoOpensYandexInNewWindowTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();

        String mainWindow = driver.getWindowHandle();

        mainPage.clickYandexLogo();

        String yandexLogoLink = mainPage.getYandexLogoLink();

        mainPage.clickYandexLogo();

        assertTrue(yandexLogoLink.contains("yandex.ru"));
    }
        @After
        public void tearDown() {
            driver.quit();
        }
}

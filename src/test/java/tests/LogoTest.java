package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoTest {

    @Test
    public void scooterLogoOpensMainPageTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();

        mainPage.clickScooterLogo();

        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

        driver.quit();
    }
    @Test
    public void  yandexLogoOpensYandexInNewWindowTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();

        String mainWindow = driver.getWindowHandle();

        mainPage.clickYandexLogo();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("yandex.ru"));

        driver.quit();
    }
}

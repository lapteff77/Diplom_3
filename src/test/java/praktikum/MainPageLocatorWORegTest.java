package praktikum;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageLocatorWORegTest {

    MainPage mainPage;

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // клик по кнопке "Войти в аккаунт"
    @DisplayName("chromeOnlyClickMainPageTest") // имя теста
    @Description("chrome - input enter in account") // описание теста
    public void chromeOnlyClickMainPageTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterMainPageButton();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "Войти в аккаунт"
    @DisplayName("yandexOnlyClickMainPageTest") // имя теста
    @Description("yandex - input enter in account") // описание теста
    public void yandexOnlyClickMainPageTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterMainPageButton();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // клик по кнопке "Личный кабинет"
    @DisplayName("chromeClickEnterUserButtonTest") // имя теста
    @Description("chrome -  entry in  personal account ") // описание теста
    public void chromeClickEnterUserButtonTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "Личный кабинет"
    @DisplayName("yandexClickEnterUserButtonTest") // имя теста
    @Description("yandex -  entry in  personal account ") // описание теста
    public void yandexClickEnterUserButtonTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        driver.quit();
    }
}

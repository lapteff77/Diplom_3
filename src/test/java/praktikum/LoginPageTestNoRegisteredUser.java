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

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPageTestNoRegisteredUser {

    LoginPage loginPage;
    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String password = "aaa" + random.nextInt(10000000);

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // ввод электронной почты, пароля (незарегистрированный юзер), клик по кнопке "войти"
    @DisplayName("chromeOnlyClickLoginPageTest") // имя теста
    @Description("chrome - input email and unregistered pass ") // описание теста
    public void chromeOnlyClickLoginPageTest() {
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
    }

    @Test
    // тест в Yandex browser
    // ввод электронной почты, пароля (незарегистрированный юзер), клик по кнопке "войти"
    @DisplayName("yandexOnlyClickLoginPageTest") // имя теста
    @Description("yandex - input email and unregistered pass ") // описание теста
    public void yandexOnlyClickLoginPageTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        driver.quit();
    }
}

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

public class ForgotPasswordPageTest {

    ForgotPasswordPage forgotPasswordPage;
    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // ввод email и клик по кнопке "восстановить"
    @DisplayName("chromeOnlyClickForgotPageTest") // имя теста
    @Description("chrome - input email and recovery pass ") // описание теста
    public void chromeOnlyClickForgotPageTest() {
        forgotPasswordPage = open(AdressForUrl.urlForgot,
                ForgotPasswordPage.class);
        forgotPasswordPage.inLoginEmail(email);
        forgotPasswordPage.inReplace();
        webdriver().shouldHave(url(AdressForUrl.urlForgot));
    }

    @Test
    // тест в Yandex browser
    // ввод email и клик по кнопке "восстановить"
    @DisplayName("yandexOnlyClickForgotPageTest") // имя теста
    @Description("yandex - input email and recovery pass ") // описание теста
    public void yandexOnlyClickForgotPageTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        forgotPasswordPage = open(AdressForUrl.urlForgot,
                ForgotPasswordPage.class);
        forgotPasswordPage.inLoginEmail(email);
        forgotPasswordPage.inReplace();
        webdriver().shouldHave(url(AdressForUrl.urlForgot));
        driver.quit();
    }
}

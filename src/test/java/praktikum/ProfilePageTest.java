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

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.restassured.RestAssured.given;

public class ProfilePageTest {

    MainPage mainPage;
    LoginPage loginPage;
    NovUserRegPage novUserRegPage;

    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String password = "aaa" + random.nextInt(10000000);
    private final String name = "uuu" + random.nextInt(10000000);
    private final String buttonKonstruktor = "//p[@class='AppHeader_header__linkText__3q_va ml-2']";
    private final String logoStellar = "//div[@class='AppHeader_header__logo__2D0X2']";
    private final String exitProfil = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']";
    private final int expectedCodeForOk = 200;
    private final int expectedCodeForSetOver = 202;
    private String token;

    @After
    public void setOver() {
        LoginUserWithApi loginUserWithApiReg = new LoginUserWithApi(email, password);
        token = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUserWithApiReg)
                .when()
                .post(AdressForUrl.urlApiLogin)
                .then()
                .log().all()
                .statusCode(expectedCodeForOk)
                .extract()
                .body()
                .path("accessToken");

        given()
                .auth()
                .oauth2(token.replace("Bearer ", ""))
                .delete(AdressForUrl.urlApiUser)
                .then()
                .log().all()
                .statusCode(expectedCodeForSetOver);

        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // переход в конструктор из личного кабинета
    @DisplayName("chromeProfilePageTest") // имя теста
    @Description("chrome -  testing Constructor link from UserProfile") // описание теста
    public void chromeProfilePageTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(buttonKonstruktor)).shouldBe(visible);
        $(byXpath(buttonKonstruktor)).click();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // переход в конструктор из личного кабинета
    @DisplayName("yandexProfilePageTest") // имя теста
    @Description("yandex -  testing Constructor link from UserProfile") // описание теста
    public void yandexProfilePageTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(buttonKonstruktor)).shouldBe(visible);
        $(byXpath(buttonKonstruktor)).click();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // переход по ссылке лого из личного кабинета
    @DisplayName("chromeProfilePageTest") // имя теста
    @Description("chrome -  testing logo link from UserProfile") // описание теста
    public void chromeProfilePageLogoTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(logoStellar)).shouldBe(visible);
        $(byXpath(logoStellar)).click();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // переход по ссылке лого из личного кабинета
    @DisplayName("yandexProfilePageTest") // имя теста
    @Description("yandex -  testing Logo link from UserProfile") // описание теста
    public void yandexProfilePageLogoTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(logoStellar)).shouldBe(visible);
        $(byXpath(logoStellar)).click();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // переход по кнопке выход из личного кабинета
    @DisplayName("chromeProfilePageExitTest") // имя теста
    @Description("chrome -  testing Exit from UserProfile") // описание теста
    public void chromeProfilePageExitTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(exitProfil)).shouldBe(visible);
        $(byXpath(exitProfil)).click();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
    }

    @Test
    // тест в Yandex browser
    // переход по кнопке выход из личного кабинета
    @DisplayName("yandexProfilePageExitTest") // имя теста
    @Description("yandex -  testing Exit from UserProfile") // описание теста
    public void yandexProfilePageExitTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        $(byXpath(exitProfil)).shouldBe(visible);
        $(byXpath(exitProfil)).click();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        driver.quit();
    }
}

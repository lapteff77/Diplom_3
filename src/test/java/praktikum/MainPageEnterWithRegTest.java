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
import static io.restassured.RestAssured.given;


public class MainPageEnterWithRegTest {

    MainPage mainPage;
    LoginPage loginPage;
    NovUserRegPage novUserRegPage;

    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String password = "aaa" + random.nextInt(10000000);
    private final String name = "uuu" + random.nextInt(10000000);
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
    // клик по кнопке "Войти в аккаунт и зарегистрироваться"
    @DisplayName("chromeClickMainPageTestAndReg") // имя теста
    @Description("chrome - input enter in account and reg") // описание теста
    public void chromeClickMainPageTestAndReg() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterMainPageButton();
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clickRegisterButton();
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "Войти в аккаунт и зарегистрироваться"
    @DisplayName("yandexClickMainPageTestAndReg") // имя теста
    @Description("yandex - input enter in account and reg") // описание теста
    public void yandexClickMainPageTestAndReg() {
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
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clickRegisterButton();
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // клик по кнопке "зарегистрироваться, без логина перейти на главную страницу и войти в аккаунт"
    @DisplayName("chromeClickMainPageTestAfterReg") // имя теста
    @Description("chrome - input enter in account after user registration") // описание теста
    public void chromeClickMainPageTestAfterReg() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterMainPageButton();
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "зарегистрироваться, без логина перейти на главную страницу и войти в аккаунт"
    @DisplayName("yandexClickMainPageTestAfterReg") // имя теста
    @Description("yandex - input enter in account after user registration") // описание теста
    public void yandexClickMainPageTestAfterReg() {
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
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterMainPageButton();
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // клик по кнопке "Личный кабинет"  с последующей регистрацией
    @DisplayName("chromeClickEnterUserButtonAndRegTest") // имя теста
    @Description("chrome -  entry in  personal account and registering ") // описание теста
    public void chromeClickEnterUserButtonAndRegTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clickRegisterButton();
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "Личный кабинет"  с последующей регистрацией
    @DisplayName("yandexClickEnterUserButtonAndRegTest") // имя теста
    @Description("yandex -  entry in  personal account and registering ") // описание теста
    public void yandexClickEnterUserButtonAndRegTest() {
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
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clickRegisterButton();
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // клик по кнопке "Личный кабинет" зарегистрированного юзера
    @DisplayName("chromeClickEnterUserButtonAfterRegTest") // имя теста
    @Description("chrome -  entry in  personal account after registered ") // описание теста
    public void chromeClickEnterUserAfterRegButtonTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
    }

    @Test
    // тест в Yandex browser
    // клик по кнопке "Личный кабинет" зарегистрированного юзера
    @DisplayName("yandexClickEnterUserButtonAfterRegTest") // имя теста
    @Description("yandex -  entry in  personal account after registered ") // описание теста
    public void yandexClickEnterUserAfterRegButtonTest() {
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
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        driver.quit();
    }
}

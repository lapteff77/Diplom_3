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
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.restassured.RestAssured.given;

public class NovUserRegPageTest {

    NovUserRegPage novUserRegPage;

    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String password = "aaa" + random.nextInt(10000000);
    private final String name = "uuu" + random.nextInt(10000000);
    private final int expectedCodeForOk = 200;
    private final int expectedCodeForSetOver = 202;
    private String token;
    private final String noCorrectPassword = "12345";
    private final String allertIncorrectPass = "//p[@class='input__error text_type_main-default']";

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }


    @Test
    // тест в Chrome browser
    // Регистрация нового пользователя (Успешная)
    @DisplayName("chromeNovUserPageTest") // имя теста
    @Description("chrome -  registering a new user") // описание теста
    public void chromeNovUserPageTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
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
    }

    @Test
    // тест в Yandex browser
    // Регистрация нового пользователя (Успешная)
    @DisplayName("yandexNovUserPageTest") // имя теста
    @Description("yandex -  registering a new user") // описание теста
    public void yandexNovUserPageTest() {
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
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        LoginUserWithApi loginUserWithApiReg = new LoginUserWithApi(email, password);
        driver.quit();

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
    }

    @Test
    // тест в Chrome browser
    // Регистрация нового пользователя (неуспешная, короткий пароль)
    @DisplayName("chromeNSucPassField") // имя теста
    @Description("chrome -  registering a new user with incorrect pass") // описание теста
    public void chromeNSucPassField() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, noCorrectPassword);
        $(byXpath(allertIncorrectPass)).shouldBe(visible);
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
    }

    @Test
    // тест в Yandex browser
    // Регистрация нового пользователя (неуспешная, короткий пароль)
    @DisplayName("yandexNSucPassField") // имя теста
    @Description("yandex - registering a new user with incorrect pass") // описание теста
    public void yandexNSucPassField() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, noCorrectPassword);
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
        $(byXpath(allertIncorrectPass)).shouldBe(visible);
        driver.quit();
    }
}

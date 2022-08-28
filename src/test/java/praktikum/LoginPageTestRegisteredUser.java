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


public class LoginPageTestRegisteredUser {

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
    // ввод электронной почты, пароля (зарегистрированный юзер), клик по кнопке "войти"
    @DisplayName("chromeClickLoginPageTest") // имя теста
    @Description("chrome - input email and pass ") // описание теста
    public void chromeClickLoginPageTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }

    @Test
    // тест в Yandex browser
    // ввод электронной почты, пароля (зарегистрированный юзер), клик по кнопке "войти"
    @DisplayName("yandexClickLoginPageTest") // имя теста
    @Description("yandex - input email and pass ") // описание теста
    public void yandexClickLoginPageTest() {
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
        driver.quit();
    }
}

package praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageEnterWithRegTest {

    MainPage mainPage;
    LoginPage loginPage;
    NovUserRegPage novUserRegPage;

    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String password = "aaa" + random.nextInt(10000000);
    private final String name = "uuu" + random.nextInt(10000000);

    @After
    public void setOver() {
        LoginUserWithApi.setOver(email, password);
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
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
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
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
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
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
    }
}

package praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProfilePageTest {

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
    // переход в конструктор из личного кабинета
    @DisplayName("chromeProfilePageTest") // имя теста
    @Description("chrome -  testing Constructor link from UserProfile") // описание теста
    public void chromeProfilePageTest() {
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
        ProfilePage.clickConstructorInProfile();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
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
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        ProfilePage.clickLogoInProfile();
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
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
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickEnterUserButton();
        webdriver().shouldHave(url(AdressForUrl.urlProfile));
        ProfilePage.clickExitProfile();
        webdriver().shouldHave(url(AdressForUrl.urlLogin));
    }
}

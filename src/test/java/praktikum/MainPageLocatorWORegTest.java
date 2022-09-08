package praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

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
}

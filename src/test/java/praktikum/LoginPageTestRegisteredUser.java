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

public class LoginPageTestRegisteredUser {

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
    // ввод электронной почты, пароля (зарегистрированный юзер), клик по кнопке "войти"
    @DisplayName("chromeClickLoginPageTest") // имя теста
    @Description("chrome - input email and pass ") // описание теста
    public void chromeClickLoginPageTest() {
        novUserRegPage = open(AdressForUrl.urlRegister,
                NovUserRegPage.class);
        novUserRegPage.novUserRegistration(name, email, password);
        loginPage = open(AdressForUrl.urlLogin,
                LoginPage.class);
        loginPage.clearFormLogin();
        loginPage.userLogin(email, password);
        webdriver().shouldHave(url(AdressForUrl.baseAdress));
    }
}

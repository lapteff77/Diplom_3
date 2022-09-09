package praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NovUserBadRegPageTest {

    NovUserRegPage novUserRegPage;

    Random random = new Random();
    private final String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    private final String name = "uuu" + random.nextInt(10000000);
    private final String noCorrectPassword = "12345";
    LoginUserWithApi loginUserWithApiReg = new LoginUserWithApi(email, noCorrectPassword);

    @After
    public void closeBrowser() {
        LoginUserWithApi.userRegBedCreate(loginUserWithApiReg);
        LoginUserWithApi.noExpectedActualCode(loginUserWithApiReg);
        Selenide.closeWebDriver();
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
        webdriver().shouldHave(url(AdressForUrl.urlRegister));
        NovUserRegPage.allertIncorrectPass.shouldBe(visible);
    }
}


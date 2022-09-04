package praktikum;


import org.junit.Test;

import java.util.Random;
import static com.codeborne.selenide.Selenide.open;

public class RegPageTest {

    RegPage regPage;
    Random random = new Random();
    String email = "something" + random.nextInt(10000000) + "@yandex.ru";
    String password = "1234567" + random.nextInt(10000000);
    String name = "uuu" + random.nextInt(10000000);


    @Test
    // Регистрация нового пользователя (Успешная)
    public void chromeRegisterPageTest() {
        regPage = open( "https://stellarburgers.nomoreparties.site/register",
                RegPage.class);

    }
}

package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

    @Before
    public void runMainTestStep(){
        // поле подключения Yandex browser
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        //открывается страница и создаётся экземпляр класса страницы
        mainPage = open( "https://qa-scooter.praktikum-services.ru/",
                MainPage.class);
    }

}

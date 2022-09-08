package praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageKonstrTest {

    @Before
    public void setUp() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
    }

    MainPage mainPage;

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "булки"
    @DisplayName("chromeChoiceBunTest") // имя теста
    @Description("chrome -  transition to bun ") // описание теста
    public void chromeChoiceBunOnlyAcceptingTest() {
        MainPage.choiceBunOnlyAccepting();
        MainPage.selectBun.shouldBe(visible);
        MainPage.theRDBun.shouldBe(visible);
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "булки" после другого раздела
    @DisplayName("chromeChoiceBunAcceptingAfterAnotherChoiceTes") // имя теста
    @Description("chrome -  Choice bun accepting after choosing sauce ") // описание теста
    public void chromeChoiceBunAcceptingAfterAnotherChoiceTest() {
        MainPage.choiceBunAcceptingAfterAnotherChoice();
        MainPage.selectBun.shouldBe(visible);
        MainPage.theRDBun.shouldBe(visible);
    }

    @Test
    // тест в Chrome browser
    //  флоу с переходом к разделу "булки" и выбор булки "R2D3" с открытием и закрытием модального окнф
    @DisplayName("chromeChoiceRDBunTest") // имя теста
    @Description("chrome -  Choice bun 'R2D3' ") // описание теста
    public void chromeChoiceRDBunTest() {
        MainPage.choiceRDBun();
        webdriver().shouldHave(url(AdressForUrl.urlModalBun));
        MainPage.closeModalWindow();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "соусы"
    @DisplayName("chromeChoiceSouseTest") // имя теста
    @Description("chrome -  transition to souse ") // описание теста
    public void chromeChoiceSouseOnlyAcceptingTest() {
        MainPage.choiceSauceOnlyAccepting();
        MainPage.selectSauce.shouldBe(visible);
        MainPage.theTraditionSouse.shouldBe(visible);
    }

    @Test
    // тест в Chrome browser
    // флоу с переходом к разделу "соусы" и выбор соуса "Соус традиционный галактический"
    @DisplayName("chromeChoiceSouseTest") // имя теста
    @Description("chrome -  Choice Souse 'Соус традиционный галактический' ") // описание теста
    public void chromeChoiceTraditionSauceTest() {
        MainPage.choiceTraditionSauce();
        webdriver().shouldHave(url(AdressForUrl.urlModalSouse));
        MainPage.closeModalWindow();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "начинки"
    @DisplayName("chromeChoiceFillingTest") // имя теста
    @Description("chrome -  transition to filling ") // описание теста
    public void chromeChoiceFillingTest() {
        MainPage.choiceFillingOnlyAccepting();
        MainPage.selectFilling.shouldBe(visible);
        MainPage.theMarsianFilling.shouldBe(visible);
    }

    @Test
    // тест в Chrome browser
    // флоу с переходом к разделу "начинки" и выбор начинки "Биокотлета из марсианской Магнолии"
    @DisplayName("chromeChoiceSouseTest") // имя теста
    @Description("chrome -  Choice filling 'Биокотлета из марсианской Магнолии' ") // описание теста
    public void chromeChoiceTraditionFillingTest() {
        MainPage.choiceMarsianFilling();
        webdriver().shouldHave(url(AdressForUrl.urlModalFilling));
        MainPage.closeModalWindow();
    }
}

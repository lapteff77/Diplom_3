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

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageKonstrTest {

    MainPage mainPage;
    private final String bunImg = "//img[@alt='Флюоресцентная булка R2-D3']";
    private final String souseImg = "//img[@alt='Соус традиционный галактический']";
    private final String fillingImg = "//img[@alt='Биокотлета из марсианской Магнолии']";

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "булки"
    @DisplayName("chromeChoiceBunTest") // имя теста
    @Description("chrome -  transition to bun ") // описание теста
    public void chromeChoiceBunTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        mainPage.clickChoiceBun();
        $(byXpath(bunImg)).shouldBe(visible);
    }

    @Test
    // тест в Yandex browser
    // переход к разделу "булки"
    @DisplayName("yandexChoiceBunTest") // имя теста
    @Description("yandex -  transition to bun ") // описание теста
    public void yandexChoiceBunTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        mainPage.clickChoiceBun();
        $(byXpath(bunImg)).shouldBe(visible);
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "соусы"
    @DisplayName("chromeChoiceSouseTest") // имя теста
    @Description("chrome -  transition to souse ") // описание теста
    public void chromeChoiceSouseTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        mainPage.clickChoiceSauce();
        $(byXpath(souseImg)).shouldBe(visible);
    }

    @Test
    // тест в Yandex browser
    // переход к разделу "соусы"
    @DisplayName("yandexChoiceSouseTest") // имя теста
    @Description("yandex -  transition to souse ") // описание теста
    public void yandexChoiceSouseTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        mainPage.clickChoiceSauce();
        $(byXpath(souseImg)).shouldBe(visible);
        driver.quit();
    }

    @Test
    // тест в Chrome browser
    // переход к разделу "начинки"
    @DisplayName("chromeChoiceFillingTest") // имя теста
    @Description("chrome -  transition to filling ") // описание теста
    public void chromeChoiceFillingTest() {
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        $(byXpath(fillingImg)).shouldBe(visible);
    }

    @Test
    // тест в Yandex browser
    // переход к разделу "начинки"
    @DisplayName("yandexChoiceFillingTest") // имя теста
    @Description("yandex -  transition to filling ") // описание теста
    public void yandexChoiceFillingTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\lapte\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("test-type=browser");
        options.addArguments("chromeoptions.args", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        mainPage = open(AdressForUrl.baseAdress,
                MainPage.class);
        mainPage.clickFillingSauce();
        $(byXpath(fillingImg)).shouldBe(visible);
        driver.quit();
    }
}

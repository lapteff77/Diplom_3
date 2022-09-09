package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // локатор кнопки "Личный Кабинет"
    @FindBy(how = How.XPATH, using = "//*[@href='/account']")
    private static SelenideElement checkEnterUserButton;

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private static SelenideElement enterMainPageButton;

    // локатор панели под "собери бургер"
    @FindBy(how = How.XPATH, using = "//div[@style='display: flex;']")
    private static SelenideElement enterPanelUnderBurger;

    // локатор заголовка  "Булки"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[1]")
    private static SelenideElement choiceBun;

    // локатор заголовка  "Булки" после выбора
    @FindBy(how = How.XPATH, using = "//div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    static SelenideElement selectBun;

    // локатор заголовка  "Соусы"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[2]")
    private static SelenideElement choiceSauce;

    // локатор заголовка  "Соусы" после выбора
    @FindBy(how = How.XPATH, using = "//div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    static SelenideElement selectSauce;

    // локатор заголовка  "Начинки"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[3]")
    private static SelenideElement choiceFilling;

    @FindBy(how = How.XPATH, using = "//div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    static SelenideElement selectFilling;

    // локатор картинки  "Флюоресцентная булка R2-D3"
    @FindBy(how = How.XPATH, using = "//img[@alt='Флюоресцентная булка R2-D3']")
    static SelenideElement theRDBun;

    // локатор картинки "Соус традиционный галактический"
    @FindBy(how = How.XPATH, using = "//img[@alt='Соус традиционный галактический']")
    static SelenideElement theTraditionSouse;

    // локатор картинки "Биокотлета из марсианской Магнолии"
    @FindBy(how = How.XPATH, using = "//img[@alt='Биокотлета из марсианской Магнолии']")
    static SelenideElement theMarsianFilling;

    // локатор кнопки "закрыть" модального окна
    @FindBy(how = How.XPATH, using = "//button[@class='Modal_modal__close_modified__3V5XS Modal_modal__close__TnseK']")
    private static SelenideElement modalCloseButton;


    public void clickEnterMainPageButton() {
        enterMainPageButton.click();
    }

    public void clickEnterUserButton() {
        checkEnterUserButton.click();
    }

    public static void choiceBunOnlyAccepting() {
        enterPanelUnderBurger.click();
    }

    public static void choiceBunAcceptingAfterAnotherChoice() {
        choiceSauce.click();
        choiceBun.click();
    }

    public static void choiceSauceOnlyAccepting() {
        choiceSauce.click();
    }

    public static void choiceFillingOnlyAccepting() {
        choiceFilling.click();
    }

    public static void choiceRDBun() {
        enterPanelUnderBurger.click();
        theRDBun.click();
    }

    public static void choiceTraditionSauce() {
        choiceSauce.click();
        theTraditionSouse.click();
    }

    public static void choiceMarsianFilling() {
        choiceFilling.click();
        theMarsianFilling.click();
    }

    public static void closeModalWindow() {
        modalCloseButton.click();
    }
}

package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // локатор кнопки "Личный Кабинет"
    @FindBy(how = How.XPATH, using = "//*[@href='/account']")
    private SelenideElement checkEnterUserButton;

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterMainPageButton;


    // локатор заголовка  "Булки"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[1]")
    private SelenideElement choiceBun;

    // локатор заголовка  "Соусы"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[2]")
    private SelenideElement choiceSauce;

    // локатор заголовка  "Начинки"
    @FindBy(how = How.XPATH, using = "//main/section[1]/div[1]/div[3]")
    private SelenideElement choiceFilling;

    // локатор картинки  "Флюоресцентная булка R2-D3"
    @FindBy(how = How.XPATH, using = "//img[@alt='Флюоресцентная булка R2-D3']")
    private SelenideElement allTheBun;

    // локатор картинки "Соус традиционный галактический"
    @FindBy(how = How.XPATH, using = "//img[@alt='Соус традиционный галактический']")
    private SelenideElement allTheSouse;

    // локатор картинки "Биокотлета из марсианской Магнолии"
    @FindBy(how = How.XPATH, using = "//img[@alt='Биокотлета из марсианской Магнолии']")
    private SelenideElement allTheFilling;

    public void clickEnterMainPageButton() {
        enterMainPageButton.click();
    }

    public void clickEnterUserButton() {
        checkEnterUserButton.click();
    }

    public void clickChoiceBun() {
        choiceBun.click();
    }

    public void clickChoiceSauce() {
        choiceSauce.click();
    }

    public void clickFillingSauce() {
        choiceFilling.click();
    }
}

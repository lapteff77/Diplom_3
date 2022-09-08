package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    // локатор лого
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    static SelenideElement logoStellar;

    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2']")
    static SelenideElement buttonKonstruktor;

    // локатор кнопки "Выxoд"
    @FindBy(how = How.XPATH, using = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement exitProfil;

    public static void clickLogoInProfile() {
        $(byXpath("//div[@class='AppHeader_header__logo__2D0X2']")).shouldBe(visible).click();
    }

    public static void clickConstructorInProfile() {

        $(byXpath("//p[@class='AppHeader_header__linkText__3q_va ml-2']")).shouldBe(visible).click();
    }

    public static void clickExitProfile() {
        $(byXpath("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")).shouldBe(visible).click();
    }
}

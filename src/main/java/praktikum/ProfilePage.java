package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    // локатор лого
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement clockLogoInProfile;

    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement enterConstructorInProfile;

    // локатор кнопки "Выxoд"
    @FindBy(how = How.XPATH, using = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement exitProfile;



    public void clickLogoInProfile() {
        clockLogoInProfile.click();
    }

    public void clickConstructorInProfile() {

        enterConstructorInProfile.click();
    }

    public void clickExitProfile() {
        exitProfile.click();
    }
}

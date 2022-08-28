package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NovUserRegPage {

    // поле ввода имя
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement inNovName;

    // поле ввода e-mail
    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input")
    private SelenideElement inNovEmail;

    // поле ввода password
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement inNovPassword;

    // поле некорректный пароль
    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/p")
    private SelenideElement inCorrectPassword;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement enterRNovRegButton;

    @FindBy(how = How.XPATH, using = "//p[@class='input__error text_type_main-default']")
    private SelenideElement allertIncorrectPass;


    public void setNovRegName(String name) {
        inNovName.setValue(name);
    }

    public void setNovRegEmail(String email) {
        inNovEmail.setValue(email);
    }

    public void setNovRegPassword(String password) {
        inNovPassword.setValue(password);
    }

    public void enterRegNovButton() {
        enterRNovRegButton.click();
    }

    public void novUserRegistration(String name, String email, String password) {
        inNovName.sendKeys(Keys.CONTROL + "A");
        inNovName.sendKeys(Keys.BACK_SPACE);
        inNovEmail.sendKeys(Keys.CONTROL + "A");
        inNovEmail.sendKeys(Keys.BACK_SPACE);
        inNovPassword.sendKeys(Keys.CONTROL + "A");
        inNovPassword.sendKeys(Keys.BACK_SPACE);
        inNovName.setValue(name);
        inNovEmail.setValue(email);
        inNovPassword.setValue(password);
        enterRNovRegButton.click();
    }

}

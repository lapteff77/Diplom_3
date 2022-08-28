package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // поле ввода e-mail
    //@FindBy(how = How.NAME,using = "name")
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement inPostEmail;

    // поле ввода password
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement inLoginPassword;

    //  поле кнопки войти
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement pressLoginButton;

    // кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[@href='/register']")
    private SelenideElement pressRegisterButton;

    // метод заполнения поля "Имя"
    public void inLoginEmail(String email) {
        inPostEmail.setValue(email);
    }

    // метод заполнения поля "Пароль"
    public void inLoginPassword(String password) {
        inLoginPassword.setValue(password);
    }

    // метод клика по кнопки "Войти"
    public void enterLoginButton() {
        pressLoginButton.click();
    }

    public void clickRegisterButton() {
        pressRegisterButton.click();
    }

    public void userLogin(String email, String password) {
        inPostEmail.sendKeys(Keys.CONTROL + "A");
        inPostEmail.sendKeys(Keys.BACK_SPACE);
        inLoginPassword.sendKeys(Keys.CONTROL + "A");
        inLoginPassword.sendKeys(Keys.BACK_SPACE);
        inPostEmail.setValue(email);
        inLoginPassword.setValue(password);
        pressLoginButton.click();
    }

    public void clearFormLogin() {
        inPostEmail.sendKeys(Keys.CONTROL + "A");
        inPostEmail.sendKeys(Keys.BACK_SPACE);
        inLoginPassword.sendKeys(Keys.CONTROL + "A");
        inLoginPassword.sendKeys(Keys.BACK_SPACE);
    }
}

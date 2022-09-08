package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    // поле ввода e-mail

    @FindBy(how = How.XPATH, using = "//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement inForgotEmail;

    // кнопка  "восстановить/сохранить"
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement inReplace;

    // метод заполнения поля "e-mail"
    public void inLoginEmail(String email) {
        inForgotEmail.setValue(email);
    }

    // метод клика по кнопки "Восстановить"
    public void inReplace() {
        inReplace.click();
    }
}

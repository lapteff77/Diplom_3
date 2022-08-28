package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegPage {

    // поле ввода имя
    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input")
    public SelenideElement inRegisterMame;

    // поле ввода e-mail
    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input")
    public SelenideElement inRegisterEmail;

    // поле ввода password
    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input")
    public SelenideElement inRegisterPassword;

    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/form/button")  //
    public SelenideElement enterRegisterButton;

    // локатор поля "некорректный пароль"
    @FindBy(how = How.CLASS_NAME, using = "input__error text_type_main-default")
    public SelenideElement incorrectPassField;



    public void setRegisterName(String name) {
        inRegisterMame.setValue(name);
    }

    public void setRegisterEmail(String email) {
        inRegisterEmail.setValue(email);
    }

    public void setRegisterPassword(String password) {
        inRegisterPassword.setValue(password);
    }

    public void enterRegisterButton(){

        enterRegisterButton.click();
    }
}

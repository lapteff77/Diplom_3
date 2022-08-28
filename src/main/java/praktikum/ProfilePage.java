package praktikum;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;


public class Profile {


    // локатор лого
    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/header/nav/div/a/svg")
    public SelenideElement checkLogoInProfile;

    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/header/nav/ul/li[1]/a/p")
    public SelenideElement enterConstructorInProfile;

    public void clickLogoInProfile(){
        checkLogoInProfile.click();
    }

    public void clickConstructorInProfile(){
        enterConstructorInProfile.click();
    }

}

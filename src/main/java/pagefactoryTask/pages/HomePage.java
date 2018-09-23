package pagefactoryTask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    @FindBy(css = ".navbar #li_myaccount")
    private WebElement buttonMyAccout;

    @FindBy(partialLinkText = "Login")
    private WebElement buttonLogIn;

    public void clickOnLoginLink(){
        buttonMyAccout.click();
        buttonLogIn.click();
    }

}

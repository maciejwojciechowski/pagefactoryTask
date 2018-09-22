package pagefactoryTask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".navbar #li_myaccount")
    private WebElement buttonMyAccout;

    @FindBy(css = "") //mozna po partialLink (cos jak contains ale po href linkach chodzi. poczytaj)
    private WebElement buttonLogIn;
}

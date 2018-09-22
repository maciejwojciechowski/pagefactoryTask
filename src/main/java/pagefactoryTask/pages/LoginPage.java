package pagefactoryTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[contains(@class, 'loginbtn')]")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void loginUsingCredencials(String email, String pass){
        wait.until(ExpectedConditions.visibilityOf(fieldEmail));
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(pass);
        buttonLogin.click();
    }


}

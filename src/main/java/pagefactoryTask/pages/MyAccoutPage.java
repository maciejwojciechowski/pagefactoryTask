package pagefactoryTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccoutPage {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//div[@id='body-section']/descendant::*[@class='RTL']")
    private WebElement welcomeText;

    public MyAccoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    public String getWelcomeMessage(){
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }
}

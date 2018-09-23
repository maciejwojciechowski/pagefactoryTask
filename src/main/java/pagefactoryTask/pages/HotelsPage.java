package pagefactoryTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HotelsPage {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//button[text()='Details']")
    private List<WebElement> listOfDetailsButtons;

    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickDetailsButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfDetailsButtons));
        listOfDetailsButtons.get(1).click();
    }


}

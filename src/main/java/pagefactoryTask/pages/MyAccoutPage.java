package pagefactoryTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MyAccoutPage {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//div[@id='body-section']/descendant::*[@class='RTL']")
    private WebElement welcomeText;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/*")
    private List<WebElement> topMenuBarElements;

    public MyAccoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    public String getWelcomeMessage(){
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }

    public ArrayList<String> getMenuItems(){
        ArrayList<String> availableMenuItems = new ArrayList<>();
        for (WebElement e : topMenuBarElements) {
            availableMenuItems.add(e.getText());
        }
        return availableMenuItems;
    }

    public void goToMenuItem(String name){
        wait.until(ExpectedConditions.visibilityOfAllElements(welcomeText));
        int elementToClickIndex = -1;
        for (WebElement e: topMenuBarElements)
            if (e.getText().equals(name)) {
                elementToClickIndex = topMenuBarElements.indexOf(e);
            }
        topMenuBarElements.get(elementToClickIndex).click();

    }
}

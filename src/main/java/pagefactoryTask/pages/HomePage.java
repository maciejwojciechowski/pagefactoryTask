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

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']")
    List<WebElement> topMenuBarElements;

    public void clickOnLoginLink(){
        buttonMyAccout.click();
        buttonLogIn.click();
    }

    public ArrayList<String> getMenuItems(){
       ArrayList<String> availableMenuItems = new ArrayList<>();
        for (WebElement e : topMenuBarElements) {
            String temp = e.getText();//to jest jeden string i ma juz wszystko. nie ma sensu robic for trzeba tylko podzielic
            availableMenuItems.add(temp);
        }
        return availableMenuItems;
    }

}

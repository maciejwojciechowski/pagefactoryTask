package pagefactoryTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelDetailedPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='mob-trip-info-head ttu']")
    private WebElement hotelSummary;

    public boolean isHotelSummaryVisible(){
        return hotelSummary.isDisplayed();
    }

}

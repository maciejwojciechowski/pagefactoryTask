package pagefactoryTask.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactoryTask.pages.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllTests {

    private static final String PAGE_URL = "https://www.phptravels.net/";
    private static final String USER_EMAIL = "user@phptravels.com";
    private static final String USER_PASS = "demouser";
    private static final String EXPECTED_WELCOME_TEXT = "Hi, Johny Smith";
    private static final ArrayList<String> EXPECTED_MENU_LIST =
            new ArrayList<>(Arrays.asList("HOME","HOTELS","FLIGHTS","TOURS","CARS","VISA","OFFERS","BLOG"));

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccoutPage myAccoutPage;
    private HotelsPage hotelsPage;
    private HotelDetailedPage hotelDetailedPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();

        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myAccoutPage = PageFactory.initElements(driver, MyAccoutPage.class);
        hotelsPage = PageFactory.initElements(driver, HotelsPage.class);
        hotelDetailedPage = PageFactory.initElements(driver, HotelDetailedPage.class);

        driver.get(PAGE_URL);
        driver.manage().window().maximize();

        homePage.clickOnLoginLink();
        loginPage.loginUsingCredencials(USER_EMAIL, USER_PASS);

    }

    @Test
    public void testIfUserLogedIn() {

        assertThat(myAccoutPage.getWelcomeMessage())
                .isEqualTo(EXPECTED_WELCOME_TEXT);
    }

    @Test
    public void testIfAllMenuElementsAvailable(){

        assertThat(myAccoutPage.getMenuItems())
                .isEqualTo(EXPECTED_MENU_LIST);

    }

    @Test
    public void testDetailsButtonOnHotelsPage(){
        myAccoutPage.goToMenuItem("HOTELS");
        hotelsPage.clickDetailsButton();

        assertThat(hotelDetailedPage.isHotelSummaryVisible())
                .isTrue();
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

}

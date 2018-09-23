package pagefactoryTask.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactoryTask.pages.HomePage;
import pagefactoryTask.pages.LoginPage;
import pagefactoryTask.pages.MyAccoutPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest {

    private static final String PAGE_URL = "https://www.phptravels.net/";
    private static final String USER_EMAIL = "user@phptravels.com";
    private static final String USER_PASS = "demouser";
    private static final String EXPECTED_WELCOME_TEXT = "Hi, Johny Smith";
    private static final ArrayList<String> MENU_LIST =
            new ArrayList<>(Arrays.asList("HOME","HOTELS","FLIGHTS","TOURS","CARS","VISA","OFFERS","BLOG"));

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccoutPage myAccoutPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();

        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myAccoutPage = PageFactory.initElements(driver, MyAccoutPage.class);

        driver.get(PAGE_URL);
        driver.manage().window().maximize();

    }

    @Test
    public void testLoginUser(){
//        homePage.clickOnLoginLink();
//        loginPage.loginUsingCredencials(USER_EMAIL, USER_PASS);
//        assertThat(myAccoutPage.getWelcomeMessage())
//                .isEqualTo(EXPECTED_WELCOME_TEXT);

        assertThat(homePage.getMenuItems())
                .isEqualTo(MENU_LIST);

    }

    @After
    public void closeBrowser(){
        driver.close();
    }

}

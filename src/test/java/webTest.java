import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class webTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testGitUrl() throws InterruptedException {

        String url = "https://github.com/";
        String login ;
        String password ;
        String status = "I'm so happy";
        String photoAddr = "C:\\Users\\student\\Documents\\source-code.png";


        driver.get(url);
        Thread.sleep(1000);

        StartPage startPage = PageFactory.initElements(driver, StartPage.class);

        LoginPage loginPage = startPage.signIn();

        HomePage homePage = loginPage.loginAs(login, password);

        homePage.openDropDownmenu();
        Thread.sleep(1000);

        Assert.assertEquals("A3z-performance", homePage.getLoginName().getText());

        Thread.sleep(1000);

        StatusPage statusPage = homePage.openStatusInput();


        Thread.sleep(1000);
        statusPage.typeStatus(status).checkBusy().openStatusDropDown().selectStatus();

        Thread.sleep(1000);
        homePage = statusPage.submitStatus();
        Thread.sleep(1000);

        SettingsPage settingsPage = homePage.selectSettings();
        Thread.sleep(1000);
        settingsPage.selectAvatar().setUploadElement();

        Thread.sleep(1000);
        AvatarPage avatarPage;
        try {
            avatarPage = settingsPage.uploadPhoto(photoAddr);
            avatarPage.setPicture();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);


        //homePage.signOut();
    }


}

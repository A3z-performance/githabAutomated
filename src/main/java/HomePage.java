import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@href=\"/A3z-performance\"]/strong")
    WebElement loginName;
    @FindBy(xpath = "//form[@class = 'logout-form']/button")
    WebElement signOutButton;
    @FindBy(xpath = "//*[@aria-label=\"View profile and more\"]")
    WebElement dropDownMenu;
    @FindBy(xpath = "//*[@href=\"/settings/profile\"]")
    WebElement settingsMenuItem;
    @FindBy(xpath = "//*[@class=\"d-flex\"]")
    WebElement statusInput;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage openDropDownmenu() {
        dropDownMenu.click();
        return this;
    }

    public StatusPage openStatusInput() {
        statusInput.click();
        return PageFactory.initElements(driver, StatusPage.class);
    }

    public WebElement getLoginName() {
        return loginName;
    }

    public SettingsPage selectSettings() {
       settingsMenuItem.click();
        return PageFactory.initElements(driver, SettingsPage.class);
    }

    public void signOut() {
        signOutButton.click();
    }


}

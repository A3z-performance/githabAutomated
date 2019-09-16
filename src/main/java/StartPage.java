import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    @FindBy(xpath="//*[@href=\"/login\"]")
    WebElement signInField;

    WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage signIn(){
        signInField.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "login_field")
    WebElement loginInputField;
    @FindBy(id = "password" )
    WebElement passwordInputField;
    @FindBy(name = "commit")
    WebElement loginButton;

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage typeUserName(String userName) {
        loginInputField.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordInputField.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginButton.submit();
        return PageFactory.initElements(driver, HomePage.class);
    }


    public HomePage loginAs(String name, String pass){
        typePassword(pass);
        typeUserName(name);
        return submitLogin();
    }
}

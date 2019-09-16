import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusPage {
    WebDriver driver;


    @FindBy(name = "message")
    WebElement statusMessageInput;
    @FindBy(name = "limited_availability")
    WebElement busyCheckBox;
    @FindBy(xpath = "//*[@class=\"js-user-status-expire-drop-down f6 dropdown details-reset details-overlay d-inline-block mr-2\"]")
    WebElement statusDropDownMenu;
    @FindBy(xpath = "//*[@class=\"width-full btn btn-primary mr-2 js-user-status-submit\"]")
    WebElement statusSubmitButton;


    public StatusPage(WebDriver driver){
        this.driver = driver;
    }



    public StatusPage typeStatus(String status) {
        WebElement statusBar = statusMessageInput;
        statusBar.clear();
        statusBar.sendKeys(status);
        return this;
    }

    public StatusPage checkBusy() {
        WebElement chBox = busyCheckBox;
        if(!chBox.isSelected())
            chBox.click();
        return this;
    }


    public StatusPage openStatusDropDown() {
        statusDropDownMenu.click();

        return this;

    }

    public StatusPage selectStatus() {
        driver.findElement(By.xpath("//*[@title=\"in 1 hour\"]")).click();
        return this;
    }

    public HomePage submitStatus() {
        statusSubmitButton.submit();
        return PageFactory.initElements(driver, HomePage.class);
    }
}

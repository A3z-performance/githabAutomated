import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AvatarPage {

    WebDriver driver;

    @FindBy(name = "op")
    WebElement setPicButton;

    public void setPicture() {
        setPicButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

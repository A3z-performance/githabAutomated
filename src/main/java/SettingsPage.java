import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SettingsPage {
    WebDriver driver;

    WebElement uploadWindow;

    @FindBy(xpath = "//*[@class=\"avatar rounded-2\"]")
    WebElement avatarPath;
    @FindBy(xpath = "//*[@class=\"dropdown-item text-normal\"]")
    WebElement selectPhoto;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public SettingsPage selectAvatar() {
        avatarPath.click();
        return this;
    }

    public void setUploadElement() {
        uploadWindow = selectPhoto;
        uploadWindow.click();
    }

    public AvatarPage uploadPhoto(String photoAdr) throws AWTException {
        setClipboardData(photoAdr);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = new Robot();
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return PageFactory.initElements(driver, AvatarPage.class);
    }

    private void setClipboardData(String str){
        StringSelection stringSelection = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}

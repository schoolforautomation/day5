package tech.schoolforautomation.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;

@Getter
public class EnrollMeModal {

    WebDriver webDriver;

    @FindBy(className = "close")
    private WebElement closeButton;

    @FindBy(id = "studentName")
    private WebElement studentName;

    @FindBy(id = "courseName")
    private WebElement courseName;

    @FindBy(id = "level")
    private WebElement level;

    @FindBy(id = "emailAddr")
    private WebElement emailAddress;

    public EnrollMeModal(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void waitUntilModalLoaded(String studentNameText) {
        new WebDriverWait(webDriver, 1)
                .until(ExpectedConditions.textToBePresentInElement(studentName, studentNameText));
    }
}

package tech.schoolforautomation.selenium.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollMeModal {

    @FindBy(id = "studentName")
    private WebElement studentNameSpan;

    @FindBy(id = "courseName")
    private WebElement courseNameSpan;

    @FindBy(id = "level")
    private WebElement levelSpan;

    @FindBy(id = "emailAddr")
    private WebElement emailAddrSpan;

    @FindBy(className = "close")
    private WebElement closeButton;

    private WebDriver webDriver;

    public EnrollMeModal(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void close() {
        getCloseButton().click();
    }

    public String getStudentName() {
        return getStudentNameSpan().getText();
    }

    public String getCourseName() {
        return getCourseNameSpan().getText();
    }

    public String getEmailAddr() {
        return getEmailAddrSpan().getText();
    }

    public String getLevel() {
        return getLevelSpan().getText();
    }
}

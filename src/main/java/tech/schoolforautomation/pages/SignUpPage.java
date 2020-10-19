package tech.schoolforautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;
import lombok.Setter;
import tech.schoolforautomation.modals.EnrollMeModal;

@Getter
@Setter
public class SignUpPage extends BasePage {

    @FindBy(xpath = "[@id=\"t01\"]/tbody/tr[1]/th")
    private List<WebElement> availableCoursesTableHeaders;

    @FindBy(xpath = "//*[@id=\\\"t01\\\"]/tbody/tr[2]/td")
    private List<WebElement> availableCoursesTableFirstRowCells;

    @FindBy(xpath = "//*[@id=\\\"t01\\\"]/tbody/tr[3]/td")
    private List<WebElement> availableCoursesTableSecondRowCells;

    @FindBy(name = "radio")
    private List<WebElement> chooseCourseRadioButtons;

    @FindBy(id = "slct")
    private WebElement levelSelect;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "message")
    private WebElement messageTextArea;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[1]/button")
    private WebElement enrollMeButton;

    private EnrollMeModal enrollMeModal;

    public SignUpPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.enrollMeModal = new EnrollMeModal(webDriver);
    }

    public void chooseCourse(int courseIndex) {
        chooseCourseRadioButtons.get(courseIndex).click();
    }

    public void selectLevel(String level) {
        new Select(levelSelect).selectByVisibleText(level);
    }

    public void fillForm(String name, String email, String message) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageTextArea.sendKeys(message);
    }

    public void enrollMe() {
        enrollMeButton.click();
    }
}

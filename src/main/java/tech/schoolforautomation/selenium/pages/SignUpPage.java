package tech.schoolforautomation.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;
import lombok.Setter;
import tech.schoolforautomation.model.SignUp;
import tech.schoolforautomation.selenium.modals.EnrollMeModal;

@Getter
@Setter
public class SignUpPage extends BasePage {

    @FindBy(name = "radio")
    private List<WebElement> radioButtons;

    @FindBy(id = "slct")
    private WebElement optionsSelect;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[1]/button")
    private WebElement enrollMeButton;

    private EnrollMeModal enrollMeModal;

    public SignUpPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
        setEnrollMeModal(new EnrollMeModal(getWebDriver()));
    }

    public EnrollMeModal fillSignUpForm(SignUp signUpData) {
        chooseCourse(signUpData.getCourseIndex());
        chooseLevel(signUpData.getLevelIndex());
        insertName(signUpData.getName());
        insertEmail(signUpData.getEmail());
        insertMessage(signUpData.getMessage());
        clickEnrollMeButton();

        new WebDriverWait(getWebDriver(), 2)
                .until(ExpectedConditions.textToBePresentInElement(getEnrollMeModal().getStudentNameSpan(), signUpData.getName()));
        return getEnrollMeModal();
    }

    public void chooseCourse(int index) {
       getRadioButtons().get(index).click();
    }

    public void chooseLevel(int index) {
        new Select(getOptionsSelect()).selectByIndex(index);
    }

    public void insertName(String name) {
        getNameInput().sendKeys(name);
    }

    public void insertEmail(String email) {
        getEmailInput().sendKeys(email);
    }

    public void insertMessage(String message) {
        getMessageInput().sendKeys(message);
    }

    public void clickEnrollMeButton() {
        getEnrollMeButton().click();
    }
}

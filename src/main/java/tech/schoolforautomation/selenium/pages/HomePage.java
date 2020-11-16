package tech.schoolforautomation.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomePage extends BasePage {

    private WebElement getStartedButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignUpPage clickGetStartedButton() {
        new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.id("get-started"))).click();

        return new SignUpPage(getWebDriver());
    }
}

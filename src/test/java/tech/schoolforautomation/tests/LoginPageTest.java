package tech.schoolforautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import tech.schoolforautomation.base.BaseTest;
import tech.schoolforautomation.pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTest() {
        logger.info("Go to Login Page");
        getWebDriver().get("http://school-for-automation.tech");

        logger.info("Enter credentials");
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("tester", "test1234");

        logger.info("Verify the Get Started button");
        WebElement getStartedButton = new WebDriverWait(getWebDriver(), 3)
                .until(webDriver -> webDriver.findElement(By.id("get-started")));
        Assert.assertTrue(getStartedButton.isDisplayed());
    }
}

package tech.schoolforautomation.tests.login;

import org.junit.Assert;
import org.testng.annotations.Test;

import tech.schoolforautomation.base.LoginBaseTest;
import tech.schoolforautomation.selenium.pages.LoginPage;

public class InvalidUsernameTestLogin extends LoginBaseTest {

    @Test
    public void invalidUsernameTest() {
        logger.info("Go to Landing Page");
        goToLandingPage();

        logger.info("Create LoginPage object and log in an invalid user");
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("testert", "test1234");

        logger.info("Verify the error message");
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Error. Please enter correct Username & password.");
    }
}

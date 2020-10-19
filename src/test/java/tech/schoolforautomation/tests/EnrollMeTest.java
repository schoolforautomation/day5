package tech.schoolforautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tech.schoolforautomation.base.BaseTest;
import tech.schoolforautomation.pages.HomePage;
import tech.schoolforautomation.pages.LoginPage;
import tech.schoolforautomation.pages.SignUpPage;

public class EnrollMeTest extends BaseTest {

    @Test
    public void enrollMeTest() {
        logger.info("Go to Login Page");
        getWebDriver().get("http://school-for-automation.tech");

        logger.info("Enter credentials");
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("tester", "test1234");

        logger.info("Get Started");
        HomePage homePage = new HomePage(getWebDriver());
        homePage.getStarted();

        logger.info("Complete course enrollment requirements");
        SignUpPage signUpPage = new SignUpPage(getWebDriver());
        signUpPage.chooseCourse(2);
        signUpPage.selectLevel("Intermediate");
        signUpPage.fillForm("Jack London", "jlondon@email.com",
                "This is just a test message. Don't take it into consideration.");
        signUpPage.enrollMe();

        logger.info("Verify Enroll Me modal information");
        signUpPage.getEnrollMeModal().waitUntilModalLoaded("Jack London");
        Assert.assertEquals(signUpPage.getEnrollMeModal().getStudentName().getText(), "Jack London");
        Assert.assertEquals(signUpPage.getEnrollMeModal().getCourseName().getText(), "Testing with Kafka");
        Assert.assertEquals(signUpPage.getEnrollMeModal().getLevel().getText(), "Intermediate");
        Assert.assertEquals(signUpPage.getEnrollMeModal().getEmailAddress().getText(), "jlondon@email.com");

        logger.info("Close modal");
        signUpPage.getEnrollMeModal().getCloseButton().click();
    }
}

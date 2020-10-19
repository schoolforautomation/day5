package tech.schoolforautomation.pages;

import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {

    WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}

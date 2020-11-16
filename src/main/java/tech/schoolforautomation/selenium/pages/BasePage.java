package tech.schoolforautomation.selenium.pages;

import org.openqa.selenium.WebDriver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BasePage {

    private WebDriver webDriver;
}

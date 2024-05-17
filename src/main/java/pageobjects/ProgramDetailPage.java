package pageobjects;

import common.Utilities;
import org.openqa.selenium.By;

public class ProgramDetailPage {
    private final static By _courseTitle = By.xpath("//h1[@data-e2e = 'hero-title']");

    public static String getCourseTitle(){
        return Utilities.findElement(_courseTitle).getText();
    }
}

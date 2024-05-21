package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramDetailPage {
    private final static By _courseTitle = By.xpath("//h1[@data-e2e = 'hero-title']");

    protected static WebElement getCourseTitleElement(){
        return Utilities.findElement(_courseTitle);
    }

    public String getCourseTitle(){
        WebDriverWait wait = new WebDriverWait(Constants.DRIVER, Constants.TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(this.getCourseTitleElement()));
        return Utilities.findElement(_courseTitle).getText();
    }


}

package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static common.Constants.driver;

public class HomePage {
    private final By _exploreProgramBtn = By.xpath("//a[@role = 'button' and contains(@href, 'Microsoft')]");

    public ProgramPage goToExploreProgramPage(){
        WebElement programElement = Utilities.findElement(_exploreProgramBtn);
        Actions actions = new Actions(Constants.driver);
        actions.moveToElement(programElement).build().perform();
        programElement.click();
        Utilities.waitForElementToDisappear(programElement);
        return new ProgramPage();
    }

    public HomePage goToCourseraPage(){
        driver.get(Constants.URL);
        return new HomePage();
    }
}

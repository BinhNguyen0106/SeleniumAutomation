package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends GeneralPage{
    private final By _exploreProgramBtn = By.xpath("//a[@role = 'button' and contains(@href, 'Microsoft')]");

    public ProgramPage goToExploreProgramPage(){
        WebElement programElement = Utilities.findElement(_exploreProgramBtn);
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(programElement).build().perform();
        programElement.click();

        return new ProgramPage();
    }

    public HomePage goToCourseraPage(){
        Constants.DRIVER.get(Constants.URL);
        return new HomePage();
    }
}

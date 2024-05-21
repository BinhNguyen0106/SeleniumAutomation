package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends GeneralPage{
    private final static By _exploreProgramBtn = By.xpath("//a[@role = 'button' and contains(@href, 'Microsoft')]");

    protected static WebElement getExploreProgramBtn(){
        return Utilities.findElement(_exploreProgramBtn);
    }
    public ProgramPage goToExploreProgramPage(){
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(this.getExploreProgramBtn()).build().perform();
        this.getExploreProgramBtn().click();

        return new ProgramPage();
    }


}

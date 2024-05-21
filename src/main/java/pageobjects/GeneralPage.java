package pageobjects;

import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By _exploreBtn = By.xpath("//button[contains(@class, 'ExploreButton')]");
    private final By _freeCourseMenuItm = By.xpath("//a[@id = 'free-course~menu-item']");
    //elements
    protected WebElement getExploreBtn(){
        return Utilities.findElement(_exploreBtn);
    }

    protected WebElement getFreeCourseMenuItm(){
        return Utilities.findElement(_freeCourseMenuItm);
    }

    public ProgramPage goToFreeCoursePage(){
        Utilities.hoverToElement(this.getExploreBtn());
        this.getFreeCourseMenuItm().click();
        return new ProgramPage();
    }

}

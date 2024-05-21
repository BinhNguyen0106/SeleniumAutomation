package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPage {
    //locators
    private final By _exploreBtn = By.xpath("//button[contains(@class, 'ExploreButton')]");
    private final By _freeCourseMenuItm = By.xpath("//a[@id = 'free-course~menu-item']");
    private final By _exploreDropdownMn = By.xpath("//div[contains(@class, 'mega-menu-overlay')]");
    //elements
    protected WebElement getExploreBtn(){
        return Utilities.findElement(_exploreBtn);
    }
    protected WebElement getFreeCourseMenuItm(){
        return Utilities.findElement(_freeCourseMenuItm);
    }
    protected WebElement getExploreDropdownMenu(){ return Utilities.findElement(_exploreDropdownMn); }
    public ProgramPage goToFreeCoursePage(){
        Utilities.hoverToElement(this.getExploreBtn());
        WebDriverWait wait = new WebDriverWait(Constants.DRIVER, Constants.TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(this.getExploreDropdownMenu()));
        this.getFreeCourseMenuItm().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(_exploreDropdownMn));
        return new ProgramPage();
    }

    public HomePage goToCourseraPage(){
        Constants.DRIVER.get(Constants.URL);
        return new HomePage();
    }

}

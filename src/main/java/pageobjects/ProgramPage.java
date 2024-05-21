package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ProgramPage {
    private final static By _freePageTtl = By.xpath("//div[@data-testid = 'top-content-block']//h2");
    private final static By _freeCourseSearchTtl = By.xpath("//div[@id = 'search-results-header-wrapper']//span");

    private final static By _programList = By.xpath("//div[@data-testid = 'product-card-cds']");
    private final static String courseItemXpath = "//div[@data-testid = 'product-card-cds']//a[h3[text() = '%s']]";

    protected static WebElement getCourseItemElement(String courseName){
        return Utilities.findElement(By.xpath(String.format(courseItemXpath, courseName)));
    }

    public static List<WebElement> getListPrograms(){
        return Constants.DRIVER.findElements(_programList);
    }

    protected WebElement getFreePageTitle(){
        return Utilities.findElement(_freePageTtl);
    }

    protected WebElement getFreeCourseSearchTitle(){
        return Utilities.findElement(_freeCourseSearchTtl);
    }

    public static ProgramDetailPage goToDetailPage(String courseName){
        WebElement courseElement = getCourseItemElement(courseName);
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(courseElement).build().perform();
        courseElement.click();
        String oldTab = Constants.DRIVER.getWindowHandle();

        ArrayList<String> newTab = new ArrayList<String>(Constants.DRIVER.getWindowHandles());
        newTab.remove(oldTab);

        Constants.DRIVER.switchTo().window(newTab.get(0));

        return new ProgramDetailPage();
    }

    public String getFreeCourseSearchTitleText(){
        return this.getFreeCourseSearchTitle().getText();
    }

    public String getFreePageTitleText(){
        return this.getFreePageTitle().getText();
    }
}

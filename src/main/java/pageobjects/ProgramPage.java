package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProgramPage {
    private final static By _freePageTtl = By.xpath("//div[@data-testid = 'top-content-block']//h2");
    private final static By _freeCourseSearchTtl = By.xpath("//div[@id = 'search-results-header-wrapper']//span");
    private final static String _freeProgramXpath = "//div[contains(@data-testid, 'product-card-cds')]";
    private final static By _freeProgramList = By.xpath(_freeProgramXpath + "//h3");
    private final static String _freeProgramCourse = _freeProgramXpath + "//div[.//h3[text() = '%s']]";
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

    protected List<WebElement> getFreeProgramList(){
        return Utilities.findElements(_freeProgramList);
    }
    protected static WebElement getFreeProgramCourse(String courseName){
        return Utilities.findElement(By.xpath(String.format(_freeProgramCourse, courseName)));
    }

    public static ProgramDetailPage goToDetailPage(String courseName){
        WebElement courseElement = getCourseItemElement(courseName);
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(courseElement).build().perform();
        courseElement.click();
        String oldTab = Constants.DRIVER.getWindowHandle();

        ArrayList<String> newTab = new ArrayList<>(Constants.DRIVER.getWindowHandles());
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

    public List<String> getFreeProgramListText(){
        List<String> programList = new ArrayList<>();
        for (int i = 0; i < this.getFreeProgramList().size(); i++){
            programList.add(this.getFreeProgramList().get(i).getText());
        }
        return programList;
    }
    public ProgramDetailPage goToFreeProgramDetailPage(String courseName){
        WebDriverWait wait = new WebDriverWait(Constants.DRIVER, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(this.getFreeProgramCourse(courseName)));
        Utilities.scrollInToView(this.getFreeProgramCourse(courseName));
        this.getFreeProgramCourse(courseName).click();
        Utilities.switchToNewTab();

        return new ProgramDetailPage();
    }
}

package pageobjects;

import common.Constants;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ProgramPage {
    private final static By _programList = By.xpath("//div[@data-testid = 'product-card-cds']");
    private final static String courseItemXpath = "//div[@data-testid = 'product-card-cds']//a[h3[text() = '%s']]";

    protected static WebElement getCourseItemElement(String courseName){
        return Utilities.findElement(By.xpath(String.format(courseItemXpath, courseName)));
    }

    public static List<WebElement> getListPrograms(){
        return Constants.driver.findElements(_programList);
    }

    public static ProgramDetailPage goToDetailPage(String courseName){
        WebElement courseElement = getCourseItemElement(courseName);
        Actions actions = new Actions(Constants.driver);
        actions.moveToElement(courseElement).build().perform();
        courseElement.click();
        String oldTab = Constants.driver.getWindowHandle();

        ArrayList<String> newTab = new ArrayList<String>(Constants.driver.getWindowHandles());
        newTab.remove(oldTab);

        Constants.driver.switchTo().window(newTab.get(0));

        return new ProgramDetailPage();
    }
}

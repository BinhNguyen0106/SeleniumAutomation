package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Utilities {
    public static WebElement findElement(By locator){
        try{
            WebElement element = Constants.DRIVER.findElement(locator);
            return element.isDisplayed() ? element : null;
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public static void hoverToElement(WebElement element){
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(element).perform();
    }

}

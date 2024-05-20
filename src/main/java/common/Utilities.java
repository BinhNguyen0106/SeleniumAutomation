package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class Utilities {
    public static WebElement findElement(By locator){
        try{
            WebElement element = Constants.driver.findElement(locator);
            return element.isDisplayed() ? element : null;
        } catch (NoSuchElementException e){
            return null;
        }
    }


}

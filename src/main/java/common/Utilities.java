package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class Utilities {
    public static WebElement findElement(By locator){
        try{
            WebElement element = Constants.DRIVER.findElement(locator);
            return element.isDisplayed() ? element : null;
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public static List<WebElement> findElements(By locator){
        try {
            List<WebElement> elements = Constants.DRIVER.findElements(locator);
            return (elements.size() != 0) ? elements : null;
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public static void hoverToElement(WebElement element){
        Actions actions = new Actions(Constants.DRIVER);
        actions.moveToElement(element).perform();
    }

    public static int randomNumber(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void scrollInToView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Constants.DRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}

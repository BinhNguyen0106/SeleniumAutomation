package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    public static WebElement findElement(By locator){
        try{
            WebElement element = (new WebDriverWait(Constants.driver, Duration.ofSeconds(Constants.TIMEOUT)))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.findElement(locator);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean waitForElementToDisappear(WebElement element){
        return new WebDriverWait(Constants.driver, Duration.ofSeconds(Constants.TIMEOUT)).until(ExpectedConditions.invisibilityOf(element));
    }

}

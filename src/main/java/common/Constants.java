package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Constants {
    public static WebDriver driver = new ChromeDriver();
    public static String URL = "https://www.coursera.org/";
    public static int TIMEOUT = 10;
}

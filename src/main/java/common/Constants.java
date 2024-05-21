package common;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Constants {
    public static WebDriver DRIVER;
    public static String URL = "https://www.coursera.org/";
    public static Duration TIMEOUT = Duration.ofSeconds(10);
}

package testcases;
import common.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp(){
        Constants.DRIVER = new ChromeDriver();
        Constants.DRIVER.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        Constants.DRIVER.quit();
    }
}

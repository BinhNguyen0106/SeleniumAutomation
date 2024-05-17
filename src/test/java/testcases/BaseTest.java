package testcases;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static common.Constants.driver;

public class BaseTest {

    @BeforeTest
    public void setUp(){
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

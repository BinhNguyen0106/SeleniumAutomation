package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProgramPage;

import java.util.List;

public class HomePageTest extends BaseTest{
    HomePage homePage = new HomePage();
    ProgramPage programPage;
    @Test
    public void verifyProgramListLoadedSuccessfully(){
        /*
        * 1. Go to Coursera Page
        * 2. Click on Explore Program button
        * 3. Verify List of program loaded successfully
        * */
        programPage = homePage.goToCourseraPage()
                                .goToExploreProgramPage();
        List<WebElement> programList = programPage.getListPrograms();
        for (int i = 0; i< programList.size(); i++){
            Assert.assertTrue(programList.get(i).isDisplayed());
        }
    }


}

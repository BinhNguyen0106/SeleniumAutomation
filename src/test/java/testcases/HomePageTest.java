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

    @Test
    public void verifyFreeCourseListLoaded() {
        String expectedPageTitle = "Build Essential Skills for Free";
        String expectedSearchTitle = "Choose the Free Course That Aligns Best With Your Educational Goals";
        String[] expected = {"Introduction to Microsoft Excel",
        "English for Common Interactions in the Workplace: Basic Level",
        "Build a free website with WordPress",
        "Business Analysis & Process Management",
        "Investment Risk Management",
        "Python for Data Science, AI & Development",
        "English for Career Development",
        "Cybersecurity for Everyone",
        "Successful Negotiation: Essential Strategies and Skills",
        "Introductory Human Physiology",
        "Google Ads for Beginners",
        "Introduction to Data Analysis using Microsoft Excel"};
        programPage = homePage.goToCourseraPage().goToFreeCoursePage();
        for (int i = 0; i < expected.length; i++){
            Assert.assertEquals(expected[i], programPage.getFreeProgramListText().get(i));
        }

        Assert.assertEquals(expectedPageTitle, programPage.getFreePageTitleText());
        Assert.assertEquals(expectedSearchTitle, programPage.getFreeCourseSearchTitleText());
    }

}

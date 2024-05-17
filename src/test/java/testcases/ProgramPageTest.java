package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProgramDetailPage;


public class ProgramPageTest extends BaseTest{
    HomePage homePage = new HomePage();
    ProgramDetailPage detailPage;

    @Test
    public void verifyProgramDetailShowAsExpected(){
        /*
         * 1. Go to Coursera Page
         * 2. Click on Explore Program button
         * 3. Go to a course detail
         * 4. Verify the title of the course is displayed same as title in program page
         * */
        String courseTitle = "Microsoft Power BI Data Analyst";
        detailPage = homePage.goToCourseraPage()
                .goToExploreProgramPage()
                .goToDetailPage(courseTitle);
        Assert.assertTrue(detailPage.getCourseTitle().contains(courseTitle));
    }
}

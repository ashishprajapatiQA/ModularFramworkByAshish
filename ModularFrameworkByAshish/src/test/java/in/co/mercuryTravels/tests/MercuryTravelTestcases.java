package in.co.mercuryTravels.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class MercuryTravelTestcases extends BaseTest{
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 

	@Test
	public void verifyUserLoginWithCorrectCredential() throws Exception{
		
		extentTest = extent.createTest("TC-001 - verify Userlogin with correct credentials");
		
		String username = configProperties.getProperty("userEmailId");
		extentTest.log(Status.INFO, "User Email-id -" + username);
		String password = configProperties.getProperty("userPassword");
		extentTest.log(Status.INFO, "User Password -" + password);
        homePage.userLogin(username,password);// this pass value to logic layer page
        String expectedWelcomeText = configProperties.getProperty("expectedWelcomeText");
        String actualWelcomeText = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
        extentTest.log(Status.INFO, "User Login Successfully");
	}

}

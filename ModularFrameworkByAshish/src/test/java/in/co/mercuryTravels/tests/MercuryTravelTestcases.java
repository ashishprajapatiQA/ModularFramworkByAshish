package in.co.mercuryTravels.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestcases extends BaseTest{
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 

	@Test
	public void verifyUserLoginWithCorrectCredential() throws Exception{
		String username = configProperties.getProperty("userEmailId");
		String password = configProperties.getProperty("userPassword");
        homePage.userLogin(username,password);// this pass value to logic layer page
        String expectedWelcomeText = configProperties.getProperty("expectedWelcomeText");
        String actualWelcomeText = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}

}

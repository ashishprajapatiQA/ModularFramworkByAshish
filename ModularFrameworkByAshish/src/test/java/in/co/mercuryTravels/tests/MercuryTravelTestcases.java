package in.co.mercuryTravels.tests;

import org.testng.annotations.Test;

public class MercuryTravelTestcases extends BaseTest{
// Here is we write the Test cases & pass value to logic layer(here all steps defined just need values) 

	@Test
	public void verifyUserLoginWithCorrectCredential() throws Exception{
		String username = "saurabh.d2106@gmail.com";
		String password = "Pro@1234";
        homePage.userLogin(username,password);// this pass value to logic layer page
	}

}
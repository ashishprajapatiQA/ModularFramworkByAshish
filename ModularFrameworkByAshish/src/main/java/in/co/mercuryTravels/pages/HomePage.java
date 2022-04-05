package in.co.mercuryTravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	// Logic layer   - what we perform step by step 
	
	@FindBy(linkText = "International Holidays")
	private WebElement internationalHolidayLink;

	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidayLink;

	@FindBy(linkText = "Luxury Rails")
	private WebElement luxuryHolidayLink;

	@FindBy(linkText = "Customer Login")
	private WebElement customerLogin;

	@FindBy(linkText = "User Login")
	private WebElement userLogin;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(linkText = "sign_user_email")
	private WebElement signUserEmailId;

	@FindBy(linkText = "sign_user_password")
	private WebElement signUserPassword;

	@FindBy(xpath = "//button[text() ='Log in']")
	private WebElement userButton;

	public HomePage(WebDriver driver) {
		super(driver); // make it super due to basePage class have also same parameterized constructor overloaded  
		PageFactory.initElements(driver, this);
	}

	public void userLogin(String username, String password) throws Exception {
        // this is logic layer for login functionality        
		// pass values to element to controls which we created to perform
		mouseControl.moveTOElement(customerLogin);
		mouseControl.moveTOElementAndClick(userLogin);
		elementControl.setText(signUserEmailId, username);
		elementControl.setText(signUserPassword, password);
		elementControl.clickElement(userButton);
	}

}

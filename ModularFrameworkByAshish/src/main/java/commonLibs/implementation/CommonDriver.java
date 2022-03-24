package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver{
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;

	public CommonDriver(String browserType) throws Exception {
		// TODO Auto-generated constructor stub
		pageloadTimeout = 60;
		elementDetectionTimeout = 10;
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ADMIN\\git\\modularFrameworkByAshish\\ModularFrameworkByAshish\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ADMIN\\git\\modularFrameworkByAshish\\ModularFrameworkByAshish\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("\n*****************Invalid Browser Type*****************");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateForward() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateBackward() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeBrowser() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAllBrowser() throws Exception {
		// TODO Auto-generated method stub
		
	}
}

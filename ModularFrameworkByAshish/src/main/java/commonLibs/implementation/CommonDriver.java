package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {
		// TODO Auto-generated constructor stub
		pageloadTimeout = 60;
		elementDetectionTimeout = 10;
		currentWorkingDirectory = System.getProperty("user.dir");

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/browserDrivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("\n*****************Invalid Browser Type*****************");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		url = url.trim();
		driver.get(url);
	}

	@Override
	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		String title = driver.getTitle();
		return title;
	}

	@Override
	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		// TODO Auto-generated method stub
		url = url.trim();
		driver.navigate().to(url);
	}

	@Override
	public void navigateForward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().forward();
	}

	@Override
	public void navigateBackward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}

	@Override
	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}

	@Override
	public void closeBrowser() throws Exception {
		// TODO Auto-generated method stub
		if (driver != null) {
			driver.close();
		}

	}

	@Override
	public void closeAllBrowser() throws Exception {
		// TODO Auto-generated method stub
		if (driver != null) {
			driver.quit();
		}
	}
}

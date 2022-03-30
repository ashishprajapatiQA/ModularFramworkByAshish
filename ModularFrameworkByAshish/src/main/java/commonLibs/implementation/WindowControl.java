package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IwindowHandle;

public class WindowControl implements IwindowHandle {

	private WebDriver driver;

	public WindowControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		// TODO Auto-generated method stub
		driver.switchTo().window(windowhandle);
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		// TODO Auto-generated method stub
		String childWindowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		driver.switchTo().window(childWindowHandle);
	}

	@Override
	public String getWindowHandle() throws Exception {
		// TODO Auto-generated method stub
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		// TODO Auto-generated method stub
		return driver.getWindowHandles();
	}

}

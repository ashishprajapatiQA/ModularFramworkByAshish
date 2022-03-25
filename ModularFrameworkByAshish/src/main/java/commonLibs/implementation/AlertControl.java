package commonLibs.implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;

public class AlertControl implements IAlert {
	private WebDriver driver;

	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}

	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() throws Exception {
		// TODO Auto-generated method stub
		getAlert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		// TODO Auto-generated method stub
		getAlert().dismiss();
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		// TODO Auto-generated method stub
		return getAlert().getText();
	}

	@Override
	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		// TODO Auto-generated method stub
		try {
			WaitUtils.waitTillAlertIsPresent(driver, timeoutInseconds);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

}

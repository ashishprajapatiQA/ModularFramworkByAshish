package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElement;

public class CommonElement implements ICommonElement {

	@Override
	public String getText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getText();
	}

	@Override
	public void clickElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.click();
	}

	@Override
	public String getAttribute(WebElement element, String atribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(atribute);
	}

	@Override
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(csspropertyName);

	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	@Override
	public boolean isElementVisiable(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	@Override
	public void setText(WebElement element, String textToWrite) throws Exception {
		// TODO Auto-generated method stub
		element.sendKeys(textToWrite);
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.clear();
	}

	@Override
	public void changeTextStatus(WebElement element, boolean expectedStatus) throws Exception {
		// TODO Auto-generated method stub
		boolean currentStatus = element.isSelected();
		if (currentStatus != expectedStatus) {
			element.click();
		}
	}

	@Override
	public int getXLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().x;
	}

	@Override
	public int getYLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().y;
	}

}

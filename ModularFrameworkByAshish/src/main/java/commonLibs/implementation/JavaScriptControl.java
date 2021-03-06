package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScriptOperations;

public class JavaScriptControl implements IJavaScriptOperations {
	private JavascriptExecutor jsEngine;

	public JavaScriptControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		jsEngine = (JavascriptExecutor) driver;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		jsEngine.executeScript(scriptToExecute);
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		// TODO Auto-generated method stub
        String jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
        jsEngine.executeScript(jsCommand);
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		return jsEngine.executeScript(scriptToExecute).toString();
	}

}

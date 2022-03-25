package commonLibs.contracts;

public interface IJavaScriptOperations {
	public void executeJavaScript(String scriptToExecute) throws Exception;

	public void scrollDown(int x, int y) throws Exception;

	public void executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception;
}

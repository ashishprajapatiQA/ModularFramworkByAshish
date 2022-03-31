package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot {
	private TakesScreenshot camera;

	public ScreenshotControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		camera = (TakesScreenshot) driver;
	}

	@Override
	public void captureAndSaveScreenshot(String pathFile) throws Exception {
		// TODO Auto-generated method stub
		pathFile = pathFile.trim();
		File imgFile, tmpFile;
		imgFile = new File(pathFile);
		if (imgFile.exists()) {
			throw new Exception("Image with this file name alaready exits....");
		}
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tmpFile, imgFile);

	}

}

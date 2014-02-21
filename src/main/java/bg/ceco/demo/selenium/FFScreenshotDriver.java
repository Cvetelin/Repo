package bg.ceco.demo.selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.google.common.collect.ImmutableMap;

public class FFScreenshotDriver extends FirefoxDriver {

	private static final String DEFAULT_TEST_NAME = "DefaultTestName";
	private static final String SCREEN_LOCATION = "\\src\\main\\webapp\\screenshots\\";
	private static final SimpleDateFormat FILE_NAME_FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss-S");
	private static final SimpleDateFormat SAVE_DIR_FORMATTER = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
	
	private String testName;
	private String saveLocation;
	private String calssName;
	
	public FFScreenshotDriver() {
		super();
		this.testName = DEFAULT_TEST_NAME;
		createSaveLoacation();
	}
	
	public FFScreenshotDriver(String testName) {
		super();
		this.testName = testName;
		createSaveLoacation();
	}
	
	public FFScreenshotDriver(String testName, String calssName) {
		super();
		this.testName = testName;
		this.calssName = calssName;
		createSaveLoacation();
	}
	
	@Override
	protected Response execute(String driverCommand, Map<String, ?> parameters) {
		takeScreenshot(driverCommand);
		Response response = super.execute(driverCommand, parameters);
		takeScreenshot(driverCommand);
		return response;
	}
	
	private void takeScreenshot(String driverCommand) {
		if (DriverCommand.NEW_SESSION.equals(driverCommand)) {
			return;
		}
		
		Command takeScreenshot = new Command(getSessionId(),
				DriverCommand.SCREENSHOT, ImmutableMap.<String, Object> of());

		try {
			// Get the screenshot as base64.
			String base64 = getCommandExecutor().execute(takeScreenshot).getValue().toString();
			// ... and convert it.
			File screenshot = OutputType.FILE.convertFromBase64Png(base64);

			FileUtils.copyFile(screenshot, new File(fileToSave()));
		} catch (IOException e) {
			log(getSessionId(), takeScreenshot.getName(), takeScreenshot, When.EXCEPTION);
			throw new UnreachableBrowserException(
					"Error communicating with the remote browser. It may have died.", e);
		}
	}
	
	private String fileToSave() {
		StringBuilder location = new StringBuilder();
		location.append(saveLocation);
		location.append(FILE_NAME_FORMATTER.format(System.currentTimeMillis()));
		location.append(".png");
		return location.toString();
	}
	
	private void createSaveLoacation() {
		StringBuilder pathToFile = new StringBuilder();
		try {
			File rootDir = new File(".");
			pathToFile.append(rootDir.getCanonicalPath());
			pathToFile.append(SCREEN_LOCATION);
			pathToFile.append(calssName);
			pathToFile.append("\\");
			pathToFile.append(testName);
			pathToFile.append("\\");
			pathToFile.append(SAVE_DIR_FORMATTER.format(System.currentTimeMillis()));
			pathToFile.append("\\");
			FileUtils.forceMkdir(new File(pathToFile.toString()));
		} catch (IOException e) {
			throw new IllegalArgumentException("Error creating dir!", e);
		}
		this.saveLocation = pathToFile.toString();
	}
}

package bg.ceco.demo.selenium;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class ModifiedInternetExplorerDriver extends InternetExplorerDriver {

	private static final String SCREEN_LOCATION = "\\src\\main\\webapp\\screenshots\\";

	private static final Integer USABLE_HEIGHT_IN_1920X1080 = 935;
	private static final Integer USABLE_WIDTH_IN_1920X1080 = 1920;
	private static final Integer USABLE_HEIGHT_IN_1680X1050 = 905;
	private static final Integer USABLE_WIDTH_IN_1680X1050 = 1680;
	private static final Integer USABLE_HEIGHT_IN_1366X768 = 622;
	private static final Integer USABLE_WIDTH_IN_1366X1050 = 1366;
	private static final Integer USABLE_HEIGHT_IN_1280X1024 = 879;
	private static final Integer USABLE_WIDTH_IN_1280X1024 = 1280;
	private static final Integer USABLE_HEIGHT_IN_1280X800 = 653;
	private static final Integer USABLE_WIDTH_IN_1280X800 = 1280;
	private static final Integer USABLE_HEIGHT_IN_1024X768 = 622;
	private static final Integer USABLE_WIDTH_IN_1024X768 = 1024;

	private static final Integer START_HEIGHT = 90; // minimum pixels taken from
													// the browser
	private static final Integer START_WIDTH = 0;

	private static final Integer SCREEN_WIDTH_IN_1920X1080 = 1920;
	private static final Integer SCREEN_WIDTH_IN_1680X1050 = 1680;
	private static final Integer SCREEN_WIDTH_IN_1366X768 = 1366;
	private static final Integer SCREEN_WIDTH_IN_1280X1024 = 1280;
	private static final Integer SCREEN_WIDTH_IN_1280X800 = 1280;
	private static final Integer SCREEN_WIDTH_IN_1024X768 = 1024;

	private static final Integer SCREEN_HEIGHT_IN_1920X1080 = 1080;
	private static final Integer SCREEN_HEIGHT_IN_1680X1050 = 1050;
	private static final Integer SCREEN_HEIGHT_IN_1366X768 = 768;
	private static final Integer SCREEN_HEIGHT_IN_1280X1024 = 1024;
	private static final Integer SCREEN_HEIGHT_IN_1280X800 = 800;
	private static final Integer SCREEN_HEIGHT_IN_1024X768 = 768;

	private String testName;
	private String location;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public ModifiedInternetExplorerDriver() {
		super();
	}

	public ModifiedInternetExplorerDriver(String testName) {
		super();
		this.testName = testName;
		createSaveLoacation();
	}

	public void captureScreen(String fileName, String driverCommand) throws Exception {
		if (DriverCommand.NEW_SESSION.equals(driverCommand)) {
			return;
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double screenHeight = screenSize.getHeight();
		Double screenWidth = screenSize.getWidth();
		if (screenWidth.intValue() == SCREEN_WIDTH_IN_1920X1080
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1920X1080) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1920X1080, USABLE_HEIGHT_IN_1920X1080));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else if (screenWidth.intValue() == SCREEN_WIDTH_IN_1680X1050
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1680X1050) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1680X1050, USABLE_HEIGHT_IN_1680X1050));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else if (screenWidth.intValue() == SCREEN_WIDTH_IN_1366X768
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1366X768) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1366X1050, USABLE_HEIGHT_IN_1366X768));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else if (screenWidth.intValue() == SCREEN_WIDTH_IN_1280X800
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1280X800) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1280X800, USABLE_HEIGHT_IN_1280X800));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else if (screenWidth.intValue() == SCREEN_WIDTH_IN_1280X1024
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1280X1024) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1280X1024, USABLE_HEIGHT_IN_1280X1024));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else if (screenWidth.intValue() == SCREEN_WIDTH_IN_1024X768
				&& screenHeight.intValue() == SCREEN_HEIGHT_IN_1024X768) {
			Rectangle screenRectangle = new Rectangle(new Dimension(
					USABLE_WIDTH_IN_1024X768, USABLE_HEIGHT_IN_1024X768));
			saveScreenShot(screenRectangle,
					generateSaveLocation(location, fileName));
		} else
			throw new LoginException("Unsupported resolution");
	}

	public void saveScreenShot(Rectangle screenRectangle, String saveLOcation)
			throws Exception {
		screenRectangle.setLocation(START_WIDTH, START_HEIGHT);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(saveLOcation));
	}

	public void simpleCaptureScreen(String fileName) throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}

	public String generateSaveLocation(String saveLocation, String fileName)
			throws Exception {
		StringBuilder location = new StringBuilder();
		location.append(saveLocation);
		location.append(fileName);
		location.append(".png");
		return location.toString();
	}

	protected void createSaveLoacation() {
		StringBuilder pathToFile = new StringBuilder();
		try {
			File rootDir = new File(".");
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
			String approximateTestStartTime = format.format(date);

			pathToFile.append(rootDir.getCanonicalPath());
			pathToFile.append(SCREEN_LOCATION);
			pathToFile.append(testName);
			pathToFile.append("\\");
			pathToFile.append(approximateTestStartTime);
			pathToFile.append("\\");
			FileUtils.forceMkdir(new File(pathToFile.toString()));
		} catch (IOException e) {
			throw new IllegalArgumentException("Error creating dir!", e);
		}
		this.location = pathToFile.toString();
	}

	@Override
	protected Response execute(String driverCommand, Map<String, ?> parameters) {

		Command command = new Command(getSessionId(), driverCommand, parameters);
		Response response;

		long start = System.currentTimeMillis();
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat format = new SimpleDateFormat(
					"dd.MM.yyyy HH-mm-ss-S");
			String timeCaptured = format.format(date);
			captureScreen(timeCaptured, driverCommand);
			log(getSessionId(), command.getName(), When.BEFORE);

			response = getCommandExecutor().execute(command);
			captureScreen(timeCaptured, driverCommand);
			if (response == null) {
				log(getSessionId(), command.getName(), When.AFTER);
				return null;
			}

			// Unwrap the response value by converting any JSON objects of the
			// form
			// {"ELEMENT": id} to RemoteWebElements.
			Object value = getElementConverter().apply(response.getValue());
			response.setValue(value);
			log(getSessionId(), command.getName(), When.AFTER);
		} catch (Exception e) {
			log(getSessionId(), command.getName(), When.EXCEPTION);
			String errorMessage = "Error communicating with the remote browser. "
					+ "It may have died.";
			if (driverCommand.equals(DriverCommand.NEW_SESSION)) {
				errorMessage = "Could not start a new session. Possible causes are "
						+ "invalid address of the remote server or browser start-up failure.";
			}
			throw new UnreachableBrowserException(errorMessage, e);
		}

		return getErrorHandler().throwIfResponseFailed(response,
				System.currentTimeMillis() - start);
	}

	public enum When {
		BEFORE, AFTER, EXCEPTION
	}
}
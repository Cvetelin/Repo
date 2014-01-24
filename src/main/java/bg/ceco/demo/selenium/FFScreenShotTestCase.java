package bg.ceco.demo.selenium;

import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FFScreenShotTestCase extends TestCase{
protected WebDriver driver;
	
	@Override
	protected void setUp() throws Exception {		
		super.setUp();
		driver = new EventFiringWebDriver(new FFScreenshotDriver(getName()));
		((EventFiringWebDriver) driver).register(
				new ListenerThatHiglilightsElements("#FFFF00", 1, 500, TimeUnit.NANOSECONDS));
	}
}

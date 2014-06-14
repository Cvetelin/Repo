package bg.ceco.demo.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FFScreenShotTestCase {
protected WebDriver driver;
	@Rule public TestName testname = new TestName();

	@Before
	public void setUp() throws Exception {
		driver = new EventFiringWebDriver(new FFScreenshotDriver(testname.getMethodName(), getClass().getSimpleName()));
		((EventFiringWebDriver) driver).register(
				new ListenerThatHiglilightsElements("#FFFF00", 1, 500, TimeUnit.NANOSECONDS));
	}
}

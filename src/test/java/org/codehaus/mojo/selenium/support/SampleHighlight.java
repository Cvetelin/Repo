package org.codehaus.mojo.selenium.support;
import java.util.concurrent.TimeUnit;

import org.codehaus.mojo.selenium.ListenerThatHiglilightsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SampleHighlight {
	
	public static void main(String[] args) throws InterruptedException {
		EventFiringWebDriver driver = new EventFiringWebDriver(new FirefoxDriver());
		driver.register(new ListenerThatHiglilightsElements("#FFFF00", 3, 500, TimeUnit.MILLISECONDS));

        driver.get("http://localhost/test.html");
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.tagName("a")).click();
        }
	}
	
}

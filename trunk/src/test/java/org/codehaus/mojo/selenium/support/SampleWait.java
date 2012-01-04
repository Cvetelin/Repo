package org.codehaus.mojo.selenium.support;

import java.util.concurrent.TimeUnit;

import org.codehaus.mojo.selenium.ListenerThatWaitsBeforeAnyAction;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class SampleWait {
	
	public static void main(String[] args) throws InterruptedException {
		EventFiringWebDriver driver = new EventFiringWebDriver(new FirefoxDriver());
		driver.register(new ListenerThatWaitsBeforeAnyAction(5, TimeUnit.SECONDS));

        driver.get("http://localhost/test.html");
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.tagName("a")).click();
        }
	}
	
}

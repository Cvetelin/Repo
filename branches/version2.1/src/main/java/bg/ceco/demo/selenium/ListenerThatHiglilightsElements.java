package bg.ceco.demo.selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class ListenerThatHiglilightsElements extends AbstractWebDriverEventListener {
	
	private long interval;
    private final int count;
    private final String color;

    public ListenerThatHiglilightsElements(int count, long interval, TimeUnit unit) {
        this("#FFFF00", count, interval, unit);
    }

    public ListenerThatHiglilightsElements(String color, int count, long interval, TimeUnit unit) {
        this.color = color;
        this.count = count;
        this.interval = TimeUnit.MILLISECONDS.convert(Math.max(0, interval), unit);
    }

    @Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		flash(element, driver);
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		flash(element, driver);
	}
	
//	public void afterFindBy(By by, WebElement element, WebDriver driver) {
//	    flash(by, element, driver);
//	  }

	private void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++) {
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}
	
//	private void flash(By by, WebElement element, WebDriver driver) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		String bgcolor = element.getCssValue("backgroundColor");
//		for (int i = 0; i < count; i++) {
//			changeColor(color, element, js);
//			changeColor(bgcolor, element, js);
//		}
//	}

	private void changeColor(String color, WebElement element, JavascriptExecutor js) {
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
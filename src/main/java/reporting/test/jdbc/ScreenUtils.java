package reporting.test.jdbc;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScreenUtils {
	private static final String FIELD_LABEL_XPATH = "//*/label[normalize-space(text())=\"{0}\"]/parent::td/following-sibling::td";
	private static final String FIELD_XPATH ="//tr/td[contains(text(),\"{0}\")]/following-sibling::td";
	public static String formatDate(Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}
	public static String generateRandomDigit(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000) + 10000;
		return String.valueOf(randomInt);
		
	}
	public static String readLabelField(WebDriver driver,String field) {
		return  driver.findElement(By.xpath(MessageFormat.format(FIELD_LABEL_XPATH, field))).getText();
		
	}
	public static String readLabelField(WebDriver driver,String field, int columnIndex) {
		return  driver.findElement(By.xpath(MessageFormat.format(FIELD_LABEL_XPATH, field) + "[" + columnIndex + "]")).getText();
		
	}

	public static String readField(WebDriver driver,String field) {
		return  driver.findElement(By.xpath(MessageFormat.format(FIELD_XPATH, field))).getText();
		
	}
}

package bg.ceco.demo;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import bg.ceco.demo.selenium.FFScreenShotTestCase;

public class SomeTest extends FFScreenShotTestCase {
	@Test
	public void test3() {
		driver.get("https://www.boursorama.com/banque-en-ligne/compte-bancaire/souscrire-en-ligne/");
		Select s = new Select(driver.findElement(By.name("A[civilite]")));
		s.selectByVisibleText("Monsieur");
		driver.findElement(By.xpath("//input[@name='A[nom]']")).sendKeys(RandomStringUtils.randomAlphabetic(8));
		driver.findElement(By.name("A[prenom]")).sendKeys(RandomStringUtils.randomAlphabetic(8));
		driver.findElement(By.name("date_declaration1[day]")).sendKeys("24");
		driver.findElement(By.name("date_declaration1[month]")).sendKeys("04");
		driver.findElement(By.name("date_declaration1[year]")).sendKeys("1980");

		driver.findElement(By.name("A[adresse1]")).sendKeys("1 Test Str.");
		driver.findElement(By.name("A[code_postal]")).sendKeys("75001");

		driver.findElement(By.name("A[tel_mobile]")).sendKeys("0604050804");
		driver.findElement(By.name("A[email]")).sendKeys("test@test.com");

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::butto")).click();

		Select s1 = new Select(driver.findElement(By.name("A[pays_naissance]")));
		s1.selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[code_postal_naissance]")).sendKeys("75001");
		new Select(driver.findElement(By.name("A[nationalite]"))).selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[profession]")).sendKeys("QA");
		new Select(driver.findElement(By.name("A[pays_residence_fiscale]"))).selectByVisibleText("FRANCE");

		new Select(driver.findElement(By.name("A[situation_famille]"))).selectByVisibleText("Pacs");
		new Select(driver.findElement(By.name("A[contribuable_americain]"))).selectByVisibleText("Non");
	}
}

package bg.ceco.demo;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestMestTest {

	@Test
	public void testMest() {
		WebDriver driver = new FirefoxDriver();
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

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

		Select s1 = new Select(driver.findElement(By.name("A[pays_naissance]")));
		s1.selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[code_postal_naissance]")).sendKeys("75001");
		new Select(driver.findElement(By.name("A[nationalite]"))).selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[profession]")).sendKeys("QA");
		new Select(driver.findElement(By.name("A[pays_residence_fiscale]"))).selectByVisibleText("FRANCE");

		new Select(driver.findElement(By.name("A[situation_famille]"))).selectByVisibleText("Pacs");
		new Select(driver.findElement(By.name("A[contribuable_americain]"))).selectByVisibleText("Non");

		new Select(driver.findElement(By.name("A[revenus]"))).selectByVisibleText("Entre 101 000 et 150 000 " + "\u20AC");
		new Select(driver.findElement(By.name("A[patrimoine]"))).selectByVisibleText("Entre 751 000 et 1 500 000 " + "\u20AC");

		new Select(driver.findElement(By.name("A[saving]"))).selectByVisibleText("Entre 30% et 60% de mon épargne");

		driver.findElement(By.xpath("//input[@name='A[mainbank]' and @value = '1']")).click();
		driver.findElement(By.xpath("//input[@name='compte[essentiel]' and @value = 'individuel']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

		driver.findElement(By.xpath("//input[@id='visa-normale-a']")).click();
		driver.findElement(By.xpath("//input[@name='A[visuel]' and @value = 1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

	}

	@Test
	public void test2() {
		WebDriver driver = new FirefoxDriver();
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

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

		Select s1 = new Select(driver.findElement(By.name("A[pays_naissance]")));
		s1.selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[code_postal_naissance]")).sendKeys("75001");
		new Select(driver.findElement(By.name("A[nationalite]"))).selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[profession]")).sendKeys("QA");
		new Select(driver.findElement(By.name("A[pays_residence_fiscale]"))).selectByVisibleText("FRANCE");

		new Select(driver.findElement(By.name("A[situation_famille]"))).selectByVisibleText("Pacs");
		new Select(driver.findElement(By.name("A[contribuable_americain]"))).selectByVisibleText("Non");

		new Select(driver.findElement(By.name("A[revenus]"))).selectByVisibleText("Entre 101 000 et 150 000 " + "\u20AC");
		new Select(driver.findElement(By.name("A[patrimoine]"))).selectByVisibleText("Entre 751 000 et 1 500 000 " + "\u20AC");

		new Select(driver.findElement(By.name("A[saving]"))).selectByVisibleText("Entre 30% et 60% de mon épargne");

		driver.findElement(By.xpath("//input[@name='A[mainbank]' and @value = '1']")).click();
		driver.findElement(By.xpath("//input[@name='compte[essentiel]' and @value = 'individuel']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();
	}

	@Test
	public void test3() {
		WebDriver driver = new FirefoxDriver();
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

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

		Select s1 = new Select(driver.findElement(By.name("A[pays_naissance]")));
		s1.selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[code_postal_naissance]")).sendKeys("75001");
		new Select(driver.findElement(By.name("A[nationalite]"))).selectByVisibleText("FRANCE");

		driver.findElement(By.name("A[profession]")).sendKeys("QA");
		new Select(driver.findElement(By.name("A[pays_residence_fiscale]"))).selectByVisibleText("FRANCE");

		new Select(driver.findElement(By.name("A[situation_famille]"))).selectByVisibleText("Pacs");
		new Select(driver.findElement(By.name("A[contribuable_americain]"))).selectByVisibleText("Non");
	}

	public void testWithoutAnotation() {
		WebDriver driver = new FirefoxDriver();
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

		driver.findElement(By.xpath("//span[contains(text(),'Valider et passer')]/parent::button")).click();

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

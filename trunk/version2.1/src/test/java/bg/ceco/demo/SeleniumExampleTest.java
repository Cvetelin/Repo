package bg.ceco.demo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumExampleTest {

	private WebDriver driver = new FirefoxDriver();

	@Before
	public void beforeTestRun() {
		// this opens the requested url
		driver.get("http://www.tu-plovdiv.bg");
	}

	@Test
	public void testSideMenuLinks() {

		driver.findElement(By.linkText("За нас")).click();
		driver.findElement(By.linkText("За Филиала")).click();

		driver.findElement(By.linkText("Студенти")).click();
		driver.findElement(By.linkText("Актуално")).click();
		driver.findElement(By.linkText("График")).click();

		driver.findElement(By.linkText("Кандидат-студенти")).click();
		driver.findElement(By.className("active")).click();
		driver.findElement(By.linkText("Специалности")).click();

		// this links are Актуално, За Университета, Студенти
		// since there is no other way to navigate to them xpath will be used
		driver.findElement(By.xpath("//a[@href='news.php']")).click();
		driver.findElement(By.linkText("Кандидат-студенти")).click();

		// Type in the earch input
		driver.findElement(By.name("search")).sendKeys("Компютърни системи и технологии");
		// click the search button
		driver.findElement(By.xpath("//input[@name='s']")).click();

		driver.findElement(By.linkText("Структура")).click();
		driver.findElement(By.linkText("Факултет по електроника и автоматика")).click();

		// Assert.assertThat(driver.findElement(By.xpath("//div[@class='content-body-text']")).getText(),
		// MatchercontainsString("Във Факултета има 5 водещи катедри и 1 център по "
		// +
		// "физическо възпитание и спорт. Преподавателите са близо 80, като около 40% са хабилитирани"
		// +
		// " - професори и доценти, а от останалите нехабилитирани преподаватели приблизително "
		// + "половината са със степен ”доктор”."));

	}

}
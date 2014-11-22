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

		driver.findElement(By.linkText("�� ���")).click();
		driver.findElement(By.linkText("�� �������")).click();

		driver.findElement(By.linkText("��������")).click();
		driver.findElement(By.linkText("��������")).click();
		driver.findElement(By.linkText("������")).click();

		driver.findElement(By.linkText("��������-��������")).click();
		driver.findElement(By.className("active")).click();
		driver.findElement(By.linkText("������������")).click();

		// this links are ��������, �� ������������, ��������
		// since there is no other way to navigate to them xpath will be used
		driver.findElement(By.xpath("//a[@href='news.php']")).click();
		driver.findElement(By.linkText("��������-��������")).click();

		// Type in the earch input
		driver.findElement(By.name("search")).sendKeys("���������� ������� � ����������");
		// click the search button
		driver.findElement(By.xpath("//input[@name='s']")).click();

		driver.findElement(By.linkText("���������")).click();
		driver.findElement(By.linkText("�������� �� ����������� � ����������")).click();

		// Assert.assertThat(driver.findElement(By.xpath("//div[@class='content-body-text']")).getText(),
		// MatchercontainsString("��� ��������� ��� 5 ������ ������� � 1 ������ �� "
		// +
		// "��������� ���������� � �����. ��������������� �� ����� 80, ���� ����� 40% �� ������������"
		// +
		// " - ��������� � �������, � �� ���������� �������������� ������������� ������������� "
		// + "���������� �� ��� ������ �������."));

	}

}
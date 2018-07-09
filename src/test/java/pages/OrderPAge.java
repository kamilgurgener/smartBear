package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainpage.mainPage;

public class OrderPAge {
	WebDriver driver;
	Faker faker = new Faker();

	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@Test(priority = 1)
	public void login() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

	}

	@Test(priority = 2)
	public void orderAProduct() throws InterruptedException {
		// driver.findElement(By.linkText("Order")).click();
		mainPage page = new mainPage(driver);
		page.orderButton.click();
		page.SelectProduct.click();
		page.quantity.sendKeys(Keys.BACK_SPACE);
		;
		// Thread.sleep(1000);
		page.quantity.sendKeys("3");
		page.discount.sendKeys(Keys.BACK_SPACE);
		page.discount.sendKeys("20");
		page.calculateButton.click(); // discount is not applying
		page.customerName.sendKeys(faker.name().fullName());
		page.streetName.sendKeys(faker.address().streetName());
		page.cityName.sendKeys(faker.address().cityName());
		page.stateName.sendKeys(faker.address().state());
		page.zipCode.sendKeys(faker.number().digits(5));
		page.visaCard.click();
		page.CardNo.sendKeys(faker.number().digits(16));

		String date = faker.number().numberBetween(1, 12) + "/" + faker.number().numberBetween(20, 30);
		page.expireDate.sendKeys("0" + date);
		page.processButton.click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

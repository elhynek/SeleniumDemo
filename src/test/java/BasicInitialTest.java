
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class BasicInitialTest extends TestBase {
	
	
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		
	}
	
	@Test(enabled = false)
	public void test0() {
		
	}
	
	@Test(enabled = true, priority = 0)
	public void test1() {
	
		driver.get(testPageURL);
		driver.manage().window().maximize();
		
		Assert.assertTrue(driver.getTitle().toLowerCase().contains(testPageName));
	}
	
	//nákup AAA baterií proklikáváním
	@Test(enabled = true, priority = 0)
	public void test2() {
	
		//AAA bateries
		driver.get(testPageURL);
		driver.manage().window().maximize();
		try {
			driver.findElement(By.partialLinkText("Odmítnout vše")).click();
		}catch (Exception e) {
			Log.info("Cookies pop-up not shown");
		}
		driver.findElement(By.partialLinkText("Poèítaèe a noteb")).click();
		driver.findElement(By.partialLinkText("Pøíslušenství")).click();
		driver.findElement(By.partialLinkText("Baterie")).click();
		driver.findElement(By.partialLinkText("Baterie")).click();
		driver.findElement(By.partialLinkText("(AAA) 20ks")).click();
		driver.findElement(By.linkText("Koupit")).click();
		
		//driver.findElement(By.xpath("//*[@id = 'alzaDialog']/[text()='Koupit'")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//absolute path to button
		//driver.findElement(By.xpath("/html[1]/body[1]/div[19]/div[3]/div[1]/div[3]/span[2]")).click();

		//workaround as there are two same buttons
		List<WebElement> listOfElems = driver.findElements(By.cssSelector(".btnx.normal.green.buy"));
		System.out.println(listOfElems.size());
		try {
			listOfElems.get(0).click();
		} catch (Exception e) {
			Log.info("elem 0 non clickable");
			System.out.println("elem 0 non clickable");
		}
		try {
			listOfElems.get(1).click();
		} catch (Exception e) {
			Log.info("elem 1 non clickable");
			System.out.println("elem 1 non clickable");
		}
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("Pokraèovat do košíku")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("(AAA) 20ks"));

	}
	
	//nákup nejlevnìjší rtx 3080 ti
	@Test(enabled = true, priority = 0)
	public void test3() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(testPageURL);
		driver.manage().window().maximize();
		try {
			driver.findElement(By.partialLinkText("Odmítnout vše")).click();
		}catch (Exception e) {
			Log.info("Cookies pop-up not shown");
		}
		driver.findElement(By.id("edtSearch")).sendKeys("rtx 3080 ti");
		driver.findElement(By.id("btnSearch")).click();
		driver.findElement(By.partialLinkText("Grafické karty NVIDIA GeForce RTX 3080 Ti")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-5")));
		driver.findElement(By.id("ui-id-5")).click();
		wait.until(ExpectedConditions.urlContains("levne"));
		driver.findElement(By.cssSelector(".box.browsingitem.js-box.canBuy.inStockAvailability.first.firstRow")).click();
		
	}
	
	@AfterMethod
	public void end() {
		
	}

}

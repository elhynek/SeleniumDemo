import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class TestBase {

	public static String testPageName = "alza.cz";
	public static String testPageURL = "https://www.alza.cz/";
	public static Logger Log = Logger.getLogger(TestBase.class);
	ChromeDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public TestBase() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hynek\\eclipse-workspace\\SeleniumDemo\\src\\main\\resources\\chromedriver.exe");
		
	}
	
	
	
	
}

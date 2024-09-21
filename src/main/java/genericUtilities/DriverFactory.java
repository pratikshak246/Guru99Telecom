package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	public static ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver()  {
		if(driver.get()==null) {
			DriverFactory df = new DriverFactory();
			return df.initBrowser();
		}else
			return driver.get();
	}
	public WebDriver initBrowser()  {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver.set(new ChromeDriver(options));		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();
	}
}

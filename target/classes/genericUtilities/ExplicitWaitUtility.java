package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtility {
	public void waitForVisibilityOfEle(WebDriver driver,int timeInSec, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.visibilityOf(ele)); 
	}
	public void waitForNumberOfWindows(WebDriver driver, int timeInSec, int numOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
		
	}
}

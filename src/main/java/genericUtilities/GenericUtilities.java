package genericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class GenericUtilities {
	public void scrollIntoViewJSE(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("argument[0].scrollIntoView(true);", ele);
	}

}

package pagesJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;

public class AccessDetailsPage {
	ExplicitWaitUtility ew;
	public static String customerID1;
	
	@FindBy(xpath = "//table[@class='alt access']")
	private WebElement customerDetailsTable;
	
	
	@FindBy(xpath = "//h3")
	private WebElement customerID;
	
	@FindBy (xpath = "//a[text() = 'Home']")
	private WebElement homeBtn;
	
	public AccessDetailsPage() {
		
		PageFactory.initElements(DriverFactory.getDriver(),this);
		ew = new ExplicitWaitUtility();
	}
	
	public boolean customerDetailsTableisDispalyed() {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, customerDetailsTable);
		return customerDetailsTable.isDisplayed();
	}
	public String getcustomerID() {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, customerID);
		customerID1 = customerID.getText();
		return customerID1;
	}
	public void clickOnHomeBtn() {
		homeBtn.click();
	}
}

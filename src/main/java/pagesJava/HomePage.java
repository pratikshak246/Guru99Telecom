package pagesJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;

public class HomePage {
	ExplicitWaitUtility ew;
	@FindBy (xpath = "//h3/a[text()='Add Customer']")
	private WebElement addCustomerLink;
	
	@FindBy (xpath = "//a[text()='Add Tariff Plan']")
	private WebElement addTariffPlanLink;
	
	@FindBy (xpath = "//a[text() = 'Add Tariff Plan to Customer']")
	private WebElement addTariffPlanToCust;
	
	
	public HomePage() {
		PageFactory.initElements( DriverFactory.getDriver(),this);
		ew = new ExplicitWaitUtility();
	}
	
	public void clickOnAddCustomerLink() {
		ew.waitForVisibilityOfEle( DriverFactory.getDriver(), 10, addCustomerLink);
		addCustomerLink.click();
	}
	public void clickOnTariffPlanLink() {
		ew.waitForVisibilityOfEle( DriverFactory.getDriver(), 10, addTariffPlanLink);
		addTariffPlanLink.click();
	}
	public void clickOnAddTariffPlanToCust() {
		ew.waitForVisibilityOfEle( DriverFactory.getDriver(), 10,addTariffPlanToCust);
		addTariffPlanToCust.click();
	}
	
}

package pagesJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;
import genericUtilities.GenericUtilities;

public class AddTariffPlanToCustomerPage {
	ExplicitWaitUtility ew;
	GenericUtilities gu;
	
	@FindBy(id = "customer_id")
	private WebElement customerID;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy (xpath = "//label")
	private WebElement SelectTariffPlansCheckbox;
	
	@FindBy (xpath = "//input[@class='fit']/parent::div")
	private WebElement addTariffPlanToCustomerBtn;
	
	@FindBy (xpath = "//h2")
	private WebElement congratulationMsg;
	
	public AddTariffPlanToCustomerPage() {
		PageFactory.initElements( DriverFactory.getDriver(),this);
		ew = new ExplicitWaitUtility();
		gu = new GenericUtilities();
	}
	
	public void enterCustID() {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, customerID);
		customerID.sendKeys(AccessDetailsPage.customerID1);
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	
	public void clickOnSelectTariffPlansCheckbox() {
		gu.scrollIntoViewJSE(SelectTariffPlansCheckbox);
		SelectTariffPlansCheckbox.click();
	}
	
	public void clickOnAddTariffPlanToCustomerBtn() {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, addTariffPlanToCustomerBtn);
		addTariffPlanToCustomerBtn.click();
	}
	public String getCongratulationMsg() {
		return congratulationMsg.getText();
	}
	public void selectTariffPlansCheckbox() {
		SelectTariffPlansCheckbox.click();
	}
	public void clickOnAddTariffPlantoCustomerBtn() {
		addTariffPlanToCustomerBtn.click();
	}
	
}

package pagesJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;

public class AddNewTariffPlanPage {
	ExplicitWaitUtility ew;
	
	@FindBy(id = "rental1")
	private WebElement monthlyRetal;
	
	@FindBy(id = "local_minutes")
	private WebElement freeLocalMinutes;
	
	@FindBy (id = "inter_minutes")
	private WebElement freeInternationalMinutes;
	
	@FindBy (id = "sms_pack")
	private WebElement freeSMSPack;
	
	@FindBy (id = "minutes_charges")
	private WebElement LocalMinutesCharges;
	
	@FindBy (id = "inter_charges")
	private WebElement InternationalMinutesCharges;
	
	@FindBy (id = "sms_charges")
	private WebElement SMSCharges;
	
	@FindBy (css = "input[name='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//h2")
	private WebElement congratulationMsg;
	
	@FindBy (className ="button")
	private WebElement HomeBtn;
	
	public AddNewTariffPlanPage() {
		PageFactory.initElements( DriverFactory.getDriver(),this);
		ew = new ExplicitWaitUtility();
	}
	
	public void enterMonthlyRetal(String rent) {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, freeLocalMinutes);
		monthlyRetal.sendKeys(rent);
	}
	
	public void enterFreeLocalMinutes(String FreeLocalMinutes) {
		freeLocalMinutes.sendKeys(FreeLocalMinutes);
	}
	
	public void enterFreeInternationalMinutes(String FreeInternationalMinutes) {
		freeInternationalMinutes.sendKeys(FreeInternationalMinutes);
	}
	
	public void enterFreeSMSPack(String FreeSMSPack) {
		freeSMSPack.sendKeys(FreeSMSPack);
	}
	
	public void enterLocalPerMinutesCharges(String localMinutesCharges) {
		LocalMinutesCharges.sendKeys(localMinutesCharges);
	}
	public void enterInternationalPerMinutesCharges(String internationalPerMinutesCharges) {
		InternationalMinutesCharges.sendKeys(internationalPerMinutesCharges);
	}

	public void enterSMSCharges(String SMSChargess) {
		SMSCharges.sendKeys(SMSChargess);
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	
	public String getTextCongratulationMsg() {
		ew.waitForVisibilityOfEle(DriverFactory.getDriver(), 10, congratulationMsg);
		return congratulationMsg.getText();
	}
	
	public void clickHomeBtn() {
		HomeBtn.click();
	}
}

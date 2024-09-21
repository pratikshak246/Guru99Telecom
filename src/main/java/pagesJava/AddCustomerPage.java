package pagesJava;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;

public class AddCustomerPage {
	ExplicitWaitUtility ew;
	
	@FindBy (xpath = "//label[text()='Done']")
	private WebElement backgroundCheckDone;
	
	@FindBy (xpath = "//label[text()='Pending']")
	private WebElement backgroundCheckPending;
	
	@FindBy  (id = "fname")
	private WebElement firstName;
	
	@FindBy (id = "lname")
	private WebElement lastName;
	
	@FindBy (id = "email")
	private WebElement email;
	
	@FindBy (css="textarea[id='message']")
	private WebElement address;	
	
	@FindBy (id = "telephoneno")
	private WebElement mobNum;
	
	@FindBy (name = "submit")
	private WebElement submitBtn;
	
	@FindBy (xpath = "//*[local-name()='svg'][1]")
	private WebElement closeAD;
	
	public AddCustomerPage() {
		PageFactory.initElements( DriverFactory.getDriver(),this);
		ew = new ExplicitWaitUtility();
	}
	
	public void manageAD() {
		boolean b = false;
		try{
			if(backgroundCheckDone.isDisplayed()) {
				b=true;
			}else
				b=false;
			
		}catch(Exception e) {
			b=false;
		}
		if(!b) {
		DriverFactory.getDriver().switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		closeAD.click();
		DriverFactory.getDriver().switchTo().defaultContent();
		}
	
	}
	public void backgroundCheck(String DonePending) {
		if(DonePending.equalsIgnoreCase("done")) {
			backgroundCheckDone.click();
		}else if(DonePending.equalsIgnoreCase("pending")) {
			backgroundCheckPending.click();
		}
	}
	
	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}
	
	public void entereMail(String Email) {
		email.sendKeys(Email);
	}
	
	public void enterAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void entermobNum(String MobNum) {
		mobNum.sendKeys(MobNum);
	}
	
	public void clickOnSubmit() {
		submitBtn.click();
	}
	
}

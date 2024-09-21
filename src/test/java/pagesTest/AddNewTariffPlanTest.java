package pagesTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ConfigReader;
import genericUtilities.ExplicitWaitUtility;
import pagesJava.AddCustomerPage;
import pagesJava.AddNewTariffPlanPage;
import pagesJava.HomePage;

public class AddNewTariffPlanTest {
	ConfigReader cr;
	AddCustomerPage acp;
	ExplicitWaitUtility ew;
	AddNewTariffPlanPage ANTP;
	@BeforeMethod
	public void launchURL() {
		cr = new ConfigReader();
		acp = new AddCustomerPage();
		ew = new ExplicitWaitUtility();
		HomePage hp=new HomePage();
		hp.clickOnTariffPlanLink();
//		AddCustomerPage acp = new AddCustomerPage();
//		acp.manageAD();
		ANTP = new AddNewTariffPlanPage();
	}
	
	@Test (dataProvider = "dataProvidor")
	public void createNewTarrifPlan(String monthlyRetal,String freeLocalMinutes,String freeInternationalMinutes,
			String freeSMSPack,String LocalMinutesCharges,String InternationalMinutesCharges,
			String SMSCharges) {
		ANTP.enterMonthlyRetal(monthlyRetal);
		ANTP.enterFreeLocalMinutes(freeLocalMinutes);
		ANTP.enterFreeInternationalMinutes(freeInternationalMinutes);
		ANTP.enterFreeSMSPack(freeSMSPack);
		ANTP.enterLocalPerMinutesCharges(LocalMinutesCharges);
		ANTP.enterInternationalPerMinutesCharges(InternationalMinutesCharges);
		ANTP.enterSMSCharges(SMSCharges);
		ANTP.clickOnSubmitBtn();
		Assert.assertEquals(ANTP.getTextCongratulationMsg(),"Congratulation you add Tariff Plan","Inorrect Congratulation MSG");
	}
	
	@AfterMethod
	public void AfterMethod() {
		ANTP.clickHomeBtn();
	}
	
	@DataProvider
	public Object[][] dataProvidor() {
		Object[][] rates = new String[1][7];
		rates[0][0]="1000";
		rates[0][1]="100";
		rates[0][2]="100";
		rates[0][3]="3000";
		rates[0][4]="10";
		rates[0][5]="15";
		rates[0][6]="5";
		return rates;
	}
}

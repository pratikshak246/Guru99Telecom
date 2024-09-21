package pagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesJava.AddTariffPlanToCustomerPage;
import pagesJava.HomePage;

public class AddTariffPlanToCustomerTest {
	
	AddTariffPlanToCustomerPage atp;
	
	@BeforeMethod
	public void launchForm() {
		HomePage hp=new HomePage();
		hp.clickOnAddTariffPlanToCust();
		atp = new AddTariffPlanToCustomerPage();
	}
	
	@Test
	public void addTarrifPlanToCust() {
		atp.enterCustID();
		atp.clickOnSubmitBtn();
		atp.clickOnAddTariffPlantoCustomerBtn();
		Assert.assertEquals(atp.getCongratulationMsg(), "Congratulation Tariff Plan assigned", "Inccorrect Cngratultion MSG");
	}
}

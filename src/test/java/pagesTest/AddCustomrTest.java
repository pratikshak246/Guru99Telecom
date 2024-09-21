package pagesTest;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ConfigReader;
import genericUtilities.DriverFactory;
import genericUtilities.ExplicitWaitUtility;
import pagesJava.AccessDetailsPage;
import pagesJava.AddCustomerPage;
import pagesJava.HomePage;

public class AddCustomrTest {
	ConfigReader cr;
	AddCustomerPage acp;
	ExplicitWaitUtility ew;
	AccessDetailsPage adp;
	@BeforeMethod
	public void launchURL() {
		cr = new ConfigReader();
		acp = new AddCustomerPage();
		ew = new ExplicitWaitUtility();
		adp = new AccessDetailsPage();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverFactory.getDriver().get(cr.getPropData("URL"));
		HomePage hp=new HomePage();
		hp.clickOnAddCustomerLink();
	}

	@Test (dataProvider="dataProvidor")
	public void addCustomer(String DoneORPending,String FirstName,String LastName,String Email,String Address,String MobNum) {
		acp.manageAD();
		acp.backgroundCheck(DoneORPending);
		acp.enterFirstName(FirstName);
		acp.enterLastName(LastName);
		acp.entereMail(Email);
		acp.enterAddress(Address);
		acp.entermobNum(MobNum);
		acp.clickOnSubmit();
		
		AccessDetailsPage.customerID1=adp.getcustomerID();
		Assert.assertTrue(adp.customerDetailsTableisDispalyed(),"Customer Details Table is not Dispalyed");
		
	}

	@DataProvider
	public Object[][] dataProvidor() {
		Object[][] dataPro = new Object[1][6];

		dataPro[0][0] = "done";
		dataPro[0][1] = "Prtiksha";
		dataPro[0][2] = "Kashid";
		dataPro[0][3] = "pratikshaK2406@gmail.com";
		dataPro[0][4] = "Pune 411014";
		dataPro[0][5] = "8765321098";

//		dataPro[1][0] = "Pending";
//		dataPro[1][1] = "Prtikshaa";
//		dataPro[1][2] = "Kashidd";
//		dataPro[1][3] = "pratikshaKa2406@gmail.com";
//		dataPro[1][4] = "Pune 411014";
//		dataPro[1][5] = "8765321198";

		return dataPro;
	}
	@AfterMethod
	public void clickOnHomeBtn() {
		adp.clickOnHomeBtn();
	}
	@AfterTest
	public void dismiss() {
		DriverFactory.getDriver().close();
	}
}

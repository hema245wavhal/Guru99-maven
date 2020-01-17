package testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Page;
import pages.Loginpage;
import pages.NewCustomer;






public class AddNewCustomer extends Page {

	
	WebDriver driver;
	Loginpage lp;
	NewCustomer nc;
	
	public static Logger log=LogManager.getLogger("Guru99");
	
	@Test
	public void Enterdcustdetails()
	{
		
	driver =initConfiguration();
		  lp = new Loginpage (driver);
		  lp.DoLogin("mngr236025", "EquhAhA");
		  nc=new NewCustomer(driver);
		  nc.Clickaddcust();
		  nc.EnterInput();
		  nc.ClickSubBtn();
		 log.debug("Add customer details and Click submit btn");
		 
		 try
			{
				nc.handleAlert();
				log.debug("Successfully added customer");
			}
			catch(Exception e)
			{
				System.out.println("no customer alert present");
			}
			
	}

	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}



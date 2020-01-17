package testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Page;
import pages.Loginpage;


public class LoginT extends Page {

	
	WebDriver driver;
	Loginpage lp;
	
	public static Logger log=LogManager.getLogger("Guru99");
	
	
	@Test(dataProvider="credentials")
	
	  public void Login(String user,String pwd) {
		  driver =initConfiguration();
		  lp = new Loginpage (driver);
		  lp.DoLogin(user,pwd);
		//  log.debug("login successfully");
		
		  String actualTitle = "Welcome To Manager's Page of Guru99 Bank";
		  
		  String expectedTitle = lp.gettitile.getText();
		 Assert.assertEquals(actualTitle, expectedTitle);
			log.debug("login successfully");
	  }
	  

	@DataProvider(name="credentials")
	public Object[][] providedata()
	{
		ExcelConfig config=new ExcelConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Credentials.xlsx");
		int rows=config.getRowCount("Sheet1");
		System.out.println("No. of rows display"+rows);
		Object data[][]=new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=config.getData("Sheet1", i, 0);
			data[i][1]=config.getData("Sheet1", i, 1);
			}
		return data;
		}
		
	@AfterMethod
	  public void tearDownMethod() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.quit();
	    }

		
}

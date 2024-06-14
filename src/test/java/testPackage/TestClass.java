package testPackage;

import java.io.IOException;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.PageClass;
import utilitiesPackage.Excelutils;


public class TestClass extends BaseClass{
	
	@Test
	public void logintest() throws IOException, InterruptedException
	{
		PageClass page=new PageClass(driver);
		page.login();
		String floc="./login.xlsx";
		String sheet="Sheet1";
		int numofrow=Excelutils.rowCount(floc, sheet);
		for(int i=1;i<=numofrow;i++)
		{
			String emailinput=Excelutils.cellValue(floc, sheet, i, 0);
			String passwordinput=Excelutils.cellValue(floc, sheet, i, 1);
			page.logindetails(emailinput, passwordinput);
			String s=page.checkvalid(emailinput, passwordinput);
			if(s.equalsIgnoreCase("pass"))
			{
				page.logout();
				Thread.sleep(10000);
				String url=driver.getCurrentUrl();
				if(i!=numofrow && url.equals("https://www.tutorialspoint.com/market/index.asp"))
				{
					page.loginafterlogout();
				}
				
			}
			
		}
	}

}

package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LogOutClass;
import PageObjectFile.LoginWebElement;
import UtilitiesFile.DataDriverTesting;

public class TestCaseClass extends BaseClass
{
	@Test(dataProvider = "DataPro")
	public void login(String user,String pass)
	{
		driver.get(url);
		log2.info("open url");
		LoginWebElement lw=new LoginWebElement(driver);
		lw.user_Name(user);
		log2.info("Enter user name");
		lw.user_Pass(pass);
		log2.info("Enter password");
		lw.user_Sub();
		log2.info("Click submit button");
		
	}
	@DataProvider(name="DataPro")
	public Object [][] searchData() throws Exception
	{
		String filename="C:\\Users\\user\\Desktop\\Data\\new123.xlsx";
		int row=DataDriverTesting.getRowCount(filename,"Sheet1");
		int col=DataDriverTesting.getCellCount(filename,"Sheet1");
		Object s1[][]=new Object[row-1][col];//
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				s1[i-1][j]=DataDriverTesting.getCellValue(filename,"Sheet1",i,j);
			}
		}
		return s1;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

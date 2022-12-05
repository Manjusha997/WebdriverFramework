package DriverFactory;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFuction.FunctionLibrary;
import Constant.PBConstant;
import Utilities.ExcelFileUtil;

public class Hybrid_DriverScript extends PBConstant {
	String inputpath="D:\\Framework_Automation\\Webdriver\\TestInput\\Hybrid.xlsx";
	String outputpath="D:\\Framework_Automation\\Webdriver\\TestOutput\\HybrideReports.xlsx";
	String TCsheet="TestCases";
	String TSsheet="TestSteps";
	ExtentReports reports;
	ExtentTest test;
	@Test
	public void startTest() throws Throwable {
		boolean res=false;
		String tcres=" ";
		//create reference object
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		//count no of rows in tssheet tcsheet
		int Tccount=xl.rowCount(TCsheet);
		int Tscount=xl.rowCount(TSsheet);
		//iterate all rows in TCsheet
		for( int i=1;i<=Tccount;i++) {
			//		store all modules names in to TcModule
			String TcModule=xl.getCellData(TCsheet, i, 1);
//			define path for html
			reports=new ExtentReports("./Webdriver/"+TcModule+FunctionLibrary.generateDate()+".html");
			test=reports.startTest(TcModule);
			reports=new ExtentReports("./reports/"+TcModule+FunctionLibrary.generateDate()+".html");
			//			read execution mode cell
			String executionmode=xl.getCellData(TCsheet, i, 2);
			if(executionmode.equalsIgnoreCase("Y")) {
				//				read tcid cell from tcsheet
				String tcid=xl.getCellData(TCsheet, i, 0);
				for(int j=1;j<=Tscount;j++)
				{
					String Decription=xl.getCellData(TSsheet, j, 2);
					String tsid= xl.getCellData(TSsheet, j, 0);
					if(tcid.equalsIgnoreCase(tsid)) 
					{
						String Keyword=xl.getCellData(TSsheet, j, 4);
						if(Keyword.equalsIgnoreCase("AdminLogin")) 
						{
							String username=xl.getCellData(TSsheet, j, 5);
							String password=xl.getCellData(TSsheet, j, 6);
							res=FunctionLibrary.VerifyLogin(username, password);
							test.log(LogStatus.INFO, Decription);
						}
						else if(Keyword.equalsIgnoreCase("NewBranchCration")) {
							String bname=xl.getCellData(TSsheet, j, 5);
							String address1=xl.getCellData(TSsheet, j, 6);
							String address2=xl.getCellData(TSsheet, j, 7);
							String address3=xl.getCellData(TSsheet, j, 8);
							String area=xl.getCellData(TSsheet, j, 9);
							String zip=xl.getCellData(TSsheet, j, 10);
							String country=xl.getCellData(TSsheet, j, 11);
							String state=xl.getCellData(TSsheet, j, 12);
							String city=xl.getCellData(TSsheet, j, 13);
							FunctionLibrary.clickbranches();
							res=FunctionLibrary.VerifyNewBranch(bname, address1, address2, address3, area, zip, country, state, city);
							test.log(LogStatus.INFO, Decription);
						}
						else if(Keyword.equalsIgnoreCase("UpdateBranch")) {
							String branchname=xl.getCellData(TSsheet, j, 5);
							String address=xl.getCellData(TSsheet, j, 6);
							String zipcode=xl.getCellData(TSsheet, j, 10);
							FunctionLibrary.clickbranches();
							res=FunctionLibrary.VerifyBranchUpdate(branchname, address, zipcode);
							test.log(LogStatus.INFO, Decription);
						}//Role 
						else if(Keyword.equalsIgnoreCase("NewRoleCration")) {
							String Role_name=xl.getCellData(TSsheet, j, 5);
							String role_des=xl.getCellData(TSsheet, j, 6);
						String role_type=xl.getCellData(TSsheet, j, 7);
						FunctionLibrary.clickRoleButn();
							res=FunctionLibrary.VerifyNewRoleCreation(Role_name,role_des ,role_type );//							
							test.log(LogStatus.INFO, Decription);
						}
//						role updateion
						else if(Keyword.equalsIgnoreCase("UpdateRole")) {
						String updaterole=xl.getCellData(TSsheet, j, 7);
						FunctionLibrary.clickRoleButn();
							res=FunctionLibrary.VerifyroleUpdate( updaterole );							
							test.log(LogStatus.INFO, Decription);
						}
						
						else if(Keyword.equalsIgnoreCase("AdminLogout")) {
							res=FunctionLibrary.Verifylogout();
							test.log(LogStatus.INFO, Decription);
						}
						//res holds true or false
						String tsres=" ";
						if(res) {

							tsres="pass";
							xl.setCellData(TSsheet, j, 3, tsres, outputpath);
							test.log(LogStatus.PASS, Decription);
						}
						else { 
							tsres="fail";
							xl.setCellData(TSsheet, j, 3, tsres, outputpath);
							test.log(LogStatus.FAIL, Decription);
						}
						tcres=tsres;
					}
				}
				reports.endTest(test);
				reports.flush();

			
			xl.setCellData(TCsheet, i, 3, tcres, outputpath);
		}
			
		else {
				xl.setCellData(TCsheet, i, 3, "Blocked", outputpath);

			}
		}
	}
}






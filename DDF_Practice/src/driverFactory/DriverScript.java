package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import utilities.ExcelFileUtile;

public class DriverScript extends AppUtile{
	String inputpath="./TestInput/DataEngine.xlsx";
	String outputpath="./TestOutPut/DDFResult.xlsx";
	@Test
	public void startTest() throws Throwable
	{
		//Create Reference object for xl path
		ExcelFileUtile xl=new ExcelFileUtile(inputpath);
		//Count Number of Rows in xl Sheet
		int rc=xl.rowCount("PrimusBank");
		Reporter.log("Number of Rows are:::: "+rc,true);
		for (int i = 1; i <=rc ; i++) {
			String USERNAME=xl.getCellData("PrimusBank", i, 0);
			String PASSWORD=xl.getCellData("PrimusBank", i, 1);
			//Call Login method
			boolean res=FunctionLibrary.Login(USERNAME, PASSWORD);
			if (res) {
				//if res is true write as Login succesLogins into Result Cell
				xl.setCellData("PrimusBank", i, 2, "Login success",outputpath);
				xl.setCellData("PrimusBank", i, 3, "PASS",outputpath);
			}
			else
			{
				//if res is false write as Login Fail into Result Cell
				xl.setCellData("PrimusBank", i, 2, "Login Failure",outputpath);
				xl.setCellData("PrimusBank", i, 3, "FAIL",outputpath);


			}


		}

	}

}

package Mini_project1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
		
		
		boolean bol = true;
		System.out.println("Enter the browser to Automate (Chrome/Edge)");
		while(bol)
		{
			Scanner sc = new Scanner(System.in);
			String Browser = sc.next();
			if(Browser.equalsIgnoreCase("Chrome") || (Browser.equalsIgnoreCase("Edge"))){
				Methods.getWebDriver(Browser);
				bol =false;
				sc.close();
			}
			else 
			{
				System.out.println("Enter Valid Browser name(Chrome/Edge)");		
			}	
		}
		
		try {
			
		File excelFile=new File("C:\\Users\\2318504\\eclipse-workspace\\Mini_Project1\\src\\main\\resources\\excel\\Details.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workBook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workBook.getSheet("UserDetails");
		// for login credentials
		XSSFRow r1=sheet.getRow(2);
		
		XSSFCell c1=r1.getCell(0);
		XSSFCell c2=r1.getCell(1);
		
		//for add employee
XSSFRow r11=sheet.getRow(5);
		
		XSSFCell c11=r11.getCell(0);
		XSSFCell c21=r11.getCell(1);
		XSSFCell c31=r11.getCell(2);
		XSSFCell c41=r11.getCell(3);
		XSSFCell c51=r11.getCell(4);
		XSSFCell c61=r11.getCell(5);
		
		
		workBook.close();
		
		//Get from Excel
		//login credential
		String Luser=c1.toString();
		String Lpass=c2.toString();
		//add user
		String fname=c11.toString();
		String mname=c21.toString();
		String lname=c31.toString();
		String uname=c41.toString();
		String pass=c51.toString();
		String cpass=c61.toString();
		
		Methods.launchwebsite();
		
		Methods.login(Luser, Lpass);

		Methods.pim();		
		
		Methods.addEmployee(fname, mname, lname, uname, pass, cpass);
		
		Methods.goToEmployeeList();
		
		Methods.editEmployee();
		
		Methods.closeBrowser();
		
		
		}
		catch(Exception e ) 
		{
			e.printStackTrace();
		}
		
	
		
	}
}


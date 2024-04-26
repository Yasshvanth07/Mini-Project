package Mini_project1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Methods {
	
	
	
	public static WebDriver driver =null;

	 
	public static WebDriver getWebDriver(String driverStr) {
 
 
		if(driverStr.equalsIgnoreCase("chrome")) 
		{
			System.out.println("Chrome Browser is selected");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(driverStr.equalsIgnoreCase("edge"))
		{
			System.out.println("Edge Browser is selected");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void launchwebsite()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		
	}
	
	public static void login(String Luser,String Lpass)
	{
		driver.findElement(By.name("username")).sendKeys(Luser);
		driver.findElement(By.name("password")).sendKeys(Lpass);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	}
	
	public static void pim()
	{
		driver.findElement(By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/pim/viewPimModule']")).click();
		
		
	}
	
	public static void addEmployee(String fname,String mname,String lname,String uname,String pass,String cpass) throws InterruptedException
	{
		driver.findElement(By.linkText("Add Employee")).click();
		

		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("middleName")).sendKeys(mname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		
		//create login details slider
				driver.findElement(By.cssSelector("span.oxd-switch-input")).click();

				//entering username 
				driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(uname);

				//entering password
				driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active' and @type='password'])[1]")).sendKeys(pass);

				//entering confirm password
				driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys(cpass);

				//click on save button
				driver.findElement(By.cssSelector("button[type='submit']")).click();
				
				  WebDriverWait wait = new WebDriverWait(driver,10);
				  WebElement ab= driver.findElement(By.id("oxd-toaster_1"));
				wait.until(ExpectedConditions.visibilityOf(ab));
				
				
	}
	
	public static void goToEmployeeList() throws InterruptedException
	{
		//click on employee list
				driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")).click();
				
				//Thread.sleep(5000);
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("window.scrollBy(0,350)", "");
				
				//select the added memeber
				
					driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")).click();
					List<WebElement> liss = driver.findElements(By.cssSelector("div.oxd-table-row"));
			
				for(WebElement ab : liss)
				{
					
					if(ab.getText().contains("Abinesh"))
					{
						ab.click();
						break;
					}
				}
				Thread.sleep(4000);
	}
	
	public static void editEmployee()
	{
		
//-----Nationality------
		
				driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")).click();

				//driver.findElement(By.xpath("//div[@class='oxd-select-option' ]/span[text()='"+country+"']")).click();
				List<WebElement> list = driver.findElements(By.className("oxd-select-option"));

				for(WebElement a : list)
				{
					if(a.getText().contains("Indian"))
					{
						a.click();
						break;
					}
					
				}
//----Martial status-----	
				   WebDriverWait wait = new WebDriverWait(driver,10);
					WebElement ab=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]")));
					ab.click();
					List<WebElement> lis = driver.findElements(By.className("oxd-select-option"));
					for(WebElement b : lis)
					{
						if(b.getText().contains("Single"))////div[@class='oxd-select-option' and @text='"+countyr+"']
						{
							b.click();
							break;
						}
					}	
//-----Radio button gender select
					driver.findElement(By.xpath("//label[text()='Male']")).click();

//-----save button----
					driver.findElement(By.xpath("(//div[@class='oxd-form-actions']/button)[1]")).click();
					
//------click on profile
					driver.findElement(By.className("oxd-userdropdown-img")).click();

//------click on Logout
					driver.findElement(By.linkText("Logout")).click();
			}

	public static void closeBrowser()
	{
		System.out.println("Employee details Added and Edited Successfully");
		driver.quit();
		
	}
}     


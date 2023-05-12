package baseclassMarathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.ExcelCode;

public class BaseClassMarathon {
	public String filename;
	
	public static RemoteWebDriver driver;
	

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url1, String user1, String pass1) throws InterruptedException
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-Notifications");
		driver=new ChromeDriver(opt);
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(user1);
		driver.findElement(By.id("password")).sendKeys(pass1);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
		
	}
	
	@DataProvider(name="DPName")
	public String[][] fetchData() throws IOException
	{
		String[][] exceldata = ExcelCode.excelMethod(filename);
		return exceldata;
	}

}

package pagesMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclassMarathon.BaseClassMarathon;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditIndividuals extends BaseClassMarathon {
	@BeforeTest
	public void beforeTestMethod()
	{
		filename="EditIndividual";
		
	}


	@Test(dataProvider="DPName")
	public  void runEditIndividuals(String namearg,String fnamearg ) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher 
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Edit
7.Select Salutation as 'Mr'
8.Enter the first name as 'Ganesh'.
9. Click on Save and Verify the first name as 'Ganesh'"

		 */

		//WebDriverManager.chromedriver().setup();
		
		WebElement clk =driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(namearg);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//.sendKeys("Kumars",Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fnamearg);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	   //Verify the first name as 'Ganesh'
		System.out.println(msg);
		if(msg.contains(fnamearg))
		{
			System.out.println("Individual was Verified and it was Edited Successfully");
		}
		else
		{
			System.out.println("Individual was Verified and it was not Edited Successfully");
		}
			
			
	}

}

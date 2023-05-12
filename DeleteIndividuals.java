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

public class DeleteIndividuals extends BaseClassMarathon {
	
	@BeforeTest
	public void beforeTestMethod()
	{
		filename="DeleteIndividual";
		
	}


	@Test(dataProvider="DPName")
	public  void runDeleteIndividuals(String delname) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Delete
7.Click on the Delete option in the displayed popup window.
8. Verify Whether Individual is Deleted using Individual last name"

		 */
		//WebDriverManager.chromedriver().setup();
		
		Thread.sleep(3000);
		WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(delname);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);////div[@class='uiPopupTrigger']
		//Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		 driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(delname,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		//Verify Whether Individual is Deleted using Individual last name"
		if(verify.contains("No items to display"))
		{
			System.out.println("Individual was verfied and it was Deleted Successfully");
		}
		else
		{
			System.out.println("Individual was verfied and it was not Deleted Successfully");
		}
	}

}

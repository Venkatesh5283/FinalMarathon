package pagesMarathon;

import java.time.Duration;

//import org.apache.hc.core5.http.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclassMarathon.BaseClassMarathon;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividuals extends BaseClassMarathon {
/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Dropdown icon in the Individuals tab
5. Click on New Individual
6. Enter the Last Name as 'Kumar'
7.Click save and verify Individuals Name"

 */
	
	@BeforeTest
	public void beforeTestMethod()
	{
		filename="CreateIndividual";
		
	}

	
	@Test(dataProvider="DPName")
	public  void runCreateIndividual(String name1) {
		
	
	
		
	
	//WebDriverManager.chromedriver().setup();

	
	

		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
	WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
	driver.executeScript("arguments[0].click();", clk);
	driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(name1);
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();

	
	if(message.contains(name1))
	{
		System.out.println("Individual was Verified and it was created Successfully");
	}
	else
	{
		System.out.println("Individual was Verified and it was not created Successfully");
	}
	
	
}
}
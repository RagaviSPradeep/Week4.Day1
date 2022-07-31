package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {

	public static void main(String[] args) {
		
		
		//Setup Webdriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch Browser
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Login into application
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click(); 
		
		//To open mobile publisher page
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//handleing browser page and swiching to new tap
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> salesForceHandle = new ArrayList<>(windowHandles);
		String nextPage=salesForceHandle.get(1);
		driver.switchTo().window(nextPage);
		
		//Handle confirmation screen
		driver.findElement(By.xpath("//button[@onclick=\"goAhead()\"]")).click();
		System.out.println("Title of The New Page: "+driver.getTitle());
		String homeScreen = salesForceHandle.get(0);
		driver.switchTo().window(homeScreen);
		
		//Close all current active session
		driver.quit();


	}

}

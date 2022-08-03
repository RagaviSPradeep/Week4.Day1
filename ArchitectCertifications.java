package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArchitectCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Setup Webdriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch Browser
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Login using credentials
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click(); 
		
		//Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();	
		
		//Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Click Resources and mouse hover on Learning On Trailhead
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		
		
		//Clilck on Salesforce Certifications
		//Click on Ceritification Administrator
		//Navigate to Certification - Administrator Overview window
		//Verify the Certifications available for Administrator Certifications should be displayed
	}

}

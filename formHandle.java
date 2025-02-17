package saucsDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class formHandle {
WebDriver driver;
	
	@BeforeMethod()
	public void setuo() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	
	
	@Test(priority = 1)
	public void validLogin() {
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority = 2)
	public void logout() {
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		driver.findElement(By.cssSelector("//a[normalize-space()='Logout']")).click();
				
	}
	@Test(priority = 3)
	public void invalidLogin() {
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Dushyant");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        // Verify error message
        String errorMessage = driver.findElement(By.className("oxd-alert-content-text")).getText();
		System.out.println(errorMessage);
	}
    @AfterMethod
    public void tearDown() {
     driver.quit();
}
}

package saucsDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Registration {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Dushyant Vikram");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Singh");
        driver.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Satna");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("dushyantvikram1801@gmail.com");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("9131119272");

        driver.findElement(By.xpath("//input[@value='Male']")).click();
		
        driver.findElement(By.id("checkbox1")).click(); // Cricket
        driver.findElement(By.id("checkbox2")).click(); // Movies
        
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='English']")).click(); // Select English
        driver.findElement(By.cssSelector("body")).click(); 
        Thread.sleep(3000);

        Select skills = new Select(driver.findElement(By.id("Skills")));
        skills.selectByVisibleText("Java");
        
        driver.findElement(By.xpath("//span[@role='combobox']")).click();
        driver.findElement(By.xpath("//li[text()='India']")).click();
        
        new Select(driver.findElement(By.id("yearbox"))).selectByVisibleText("2000");
        new Select(driver.findElement(By.xpath("//select[@placeholder='Month']"))).selectByVisibleText("January");
        new Select(driver.findElement(By.id("daybox"))).selectByVisibleText("18");
        
        //Upload Photo
        driver.findElement(By.cssSelector("#imagesrc")).sendKeys("\"C:\\Users\\Lenovo\\Downloads\\my img.jpg\"");
        
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("dvs@18");
        
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("dvs@18");
         driver.findElement(By.cssSelector("#submitbtn")).click();
        
      
	}

}
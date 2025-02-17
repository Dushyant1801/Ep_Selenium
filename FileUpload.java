package saucsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         
         driver.get("https://demo.guru99.com/test/upload/");
         
         WebElement uploadInput = driver.findElement(By.id("uploadfile_0"));
         uploadInput.sendKeys("C:\\Users\\Lenovo\\Downloads\\DushyantVikramSingh-SDETQA-EbHS.pdf");
         driver.findElement(By.id("terms")).click();
         driver.findElement(By.cssSelector("#submitbutton")).click();
         System.out.println("Successfull");
         
	}
}

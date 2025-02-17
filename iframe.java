package saucsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {
    public static void main(String[] args) {
       
        // Initialize WebDriver
    	 WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();

           
        	 try {
                
                 driver.get("https://demoqa.com/frames");

                 // Maximize the browser window
                 driver.manage().window().maximize();

                 
                 driver.switchTo().frame("frame1");

                 
                 WebElement heading = driver.findElement(By.id("sampleHeading"));

                
                 System.out.println("Text inside the iframe: " + heading.getText());
                 Thread.sleep(2000);
      
                 driver.switchTo().defaultContent();

                 
                 System.out.println("Switched back to the main content.");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

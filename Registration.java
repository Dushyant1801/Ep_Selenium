package saucsDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
   	 WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        

        // Open the Registration Page
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Fill First Name
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Dushyant Vikram");

        // Fill Last Name
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("SingH");

        // Fill Address
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Satna");

        // Fill Email
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dushyantvikram1801@example.com");

        // Fill Phone Number
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9131119272");
        
        //File Upload
        driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\Lenovo\\Downloads\\nike.png");
        


        // Select Gender (Male)
        driver.findElement(By.xpath("//input[@value='Male']")).click();

        // Select Hobbies (Cricket & Movies)
        driver.findElement(By.id("checkbox1")).click();
        driver.findElement(By.id("checkbox2")).click();

        // Select Skills (Java)
        Select skillsDropdown = new Select(driver.findElement(By.id("Skills")));
        skillsDropdown.selectByVisibleText("Java");

        // Select Country
        

        // Click on the Language Dropdown
        WebElement languageDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("msdd")));
        languageDropdown.click();

        // Click on the "English" language using JavaScript Executor
        WebElement englishOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='English']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", englishOption);

        // Click outside to close dropdown
        WebElement languagesLabel = driver.findElement(By.xpath("//label[text()='Languages']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", languagesLabel);
        
        
        
        driver.findElement(By.cssSelector("span[role='combobox']")).click();
        driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("India");
        driver.findElement(By.xpath("//li[@role='treeitem']")).click();
        
        
        
        Select yearDropdown = new Select(driver.findElement(By.id("yearbox")));
        yearDropdown.selectByVisibleText("2000");

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        monthDropdown.selectByVisibleText("January");

        Select dayDropdown = new Select(driver.findElement(By.id("daybox")));
        dayDropdown.selectByVisibleText("18");

        // Enter Password
        driver.findElement(By.id("firstpassword")).sendKeys("Test@123");

        // Confirm Password
        driver.findElement(By.id("secondpassword")).sendKeys("Test@123");
       

        // Click Submit
        driver.findElement(By.id("submitbtn")).click();

        // Pause for a few seconds to see the result
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}

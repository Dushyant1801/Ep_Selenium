package saucsDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class search {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to OpenCart demo site
        driver.get("https://demo.opencart.com/");
        
        // Perform search for 'iPhone'
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchBox.sendKeys("iPhone");

        driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).click();	
        
        // Wait to allow elements to load
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // DropDown
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-category")));
        dropDown.click();
        Select select = new Select(dropDown);
        select.selectByVisibleText("Phones & PDAs");
        driver.findElement(By.xpath("//button[@id='button-search']"));
        
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected Category: " + selectedOption.getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='product-thumb']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        Thread.sleep(5000);
        WebElement cart = driver.findElement(By.cssSelector(".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle"));
        cart.click();
        Select select1 = new Select(dropDown);
        select1.selectByVisibleText("1 item(s) - $123.20");
       driver.findElement(By.cssSelector("a[title='Checkout'] span[class='d-none d-md-inline']")).click();
        
        
        // Verify search results;
        WebElement result = driver.findElement(By.xpath("//div[@class='product-thumb']")).findElement(By.tagName("p"));
        System.out.println("First search result: " + result.getText());

       
    }
}

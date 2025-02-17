package saucsDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class saucsDemoLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
            
            System.out.println("✅ Login Successful!");
            Thread.sleep(3000);
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            addToCartButton.click();
            
            WebElement GotoCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
            GotoCart.click();
            Thread.sleep(3000);

            WebElement CheckOut = driver.findElement(By.cssSelector("#checkout"));
            CheckOut.click();
            Thread.sleep(3000);
            

            driver.findElement(By.id("first-name")).sendKeys("Dushyant Vikram");
            driver.findElement(By.id("last-name")).sendKeys("Singh");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();
           
            wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));

            if (driver.getCurrentUrl().contains("checkout-step-two.html")) {
                System.out.println("✅ Successfully Proceeded to Checkout Step Two!");
            } else {
                System.out.println("❌ Checkout Step One Test Failed!");
            }

            driver.findElement(By.cssSelector("#finish")).click();
            
            WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
            
            
            
            if (cartBadge.getText().equals("1")) {
                System.out.println("✅ Product successfully added to cart!");
            } else {
                System.out.println("❌ Add to Cart Test Failed!");
            }
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Test encountered an error: " + e.getMessage());
        } finally {
          
        					
        }
    }
}

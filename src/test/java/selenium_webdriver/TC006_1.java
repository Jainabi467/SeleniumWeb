package selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_1 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
      

        // Step 1: Open site and login
        driver.get("http://demo.opencart.com/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("yourEmail@test.com");  // replace with Lab1 creds
        driver.findElement(By.id("input-password")).sendKeys("yourPassword");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Step 2: Components -> Monitors
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();

        // Step 3: Show 25
        WebElement showDropdown = driver.findElement(By.id("input-limit"));
        Select select = new Select(showDropdown);
        select.selectByVisibleText("25");

        // Step 4: Add to Cart (fixed locator)
        driver.findElement(By.xpath("(//button[@title='Add to Cart'])[1]")).click();

        // Step 5: Specification tab
        driver.findElement(By.linkText("Specification")).click();
        Thread.sleep(2000); // pause to view

        // Step 6: Add to Wish list
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List' or @title='Add to Wish List']")).click();

        // Step 7: Verify Success message
        String msg = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println("Message displayed: " + msg);

        // Step 8: Search Mobile
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("div#search button")).click();

        // Step 9: Search in descriptions + HTC Touch HD
        driver.findElement(By.id("description")).click();
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // Step 10: Qty = 3
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");

        driver.findElement(By.id("button-cart")).click();

        // Step 11: Verify success message
        String msg2 = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println("Message displayed: " + msg2);

        // Step 12: View Cart
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        // Step 13: Checkout
        driver.findElement(By.linkText("Checkout")).click();

        // Step 14: Logout
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();

        // Verify Logout
        String heading = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Heading after logout: " + heading);

        driver.findElement(By.linkText("Continue")).click();

        driver.quit();
    }
}

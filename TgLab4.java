package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TgLab4 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println("Firefox launched");
    }

    @Test
    public void lab3Flow() throws InterruptedException {
        // Step 1: Open URL
        driver.get("https://tutorialsninja.com/demo/");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        // Step 2: Verify title
        Assert.assertTrue(title.contains("Your Store"), "Page title mismatch!");

        // Step 3: Go to Desktops > Show All Desktops
        driver.findElement(By.linkText("Desktops")).click();
        // Step 4: Click on Mac
        driver.findElement(By.linkText("Mac (1)")).click();

        // Step 5: Verify Mac heading
        String macHeading = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(macHeading, "Mac", "Heading not matching!");

        // Step 6: Select 'Name (A - Z)' from Sort By
        Select sortBy = new Select(driver.findElement(By.id("input-sort")));
        sortBy.selectByVisibleText("Name (A - Z)");

        // Step 7: Add to Cart
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        Thread.sleep(2000);

        // Step 8: Search "Monitors"
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(2000);

        // Step 9: Clear text, check product description
        searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        driver.findElement(By.name("description")).click();
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        System.out.println("Test Flow Completed Successfully!");
    }

    @AfterMethod
    public void afterMethod() {
            driver.quit();
            System.out.println("Browser closed");
    }
}

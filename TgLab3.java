package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TgLab3 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser launched");
    }

    @Test
    public void f() throws InterruptedException {
        // Step 1: Open URL
        driver.get("https://tutorialsninja.com/demo/");
        System.out.println("Title is: " + driver.getTitle());

        // Step 2: Click on "Desktops"
        driver.findElement(By.linkText("Desktops")).click();
        Thread.sleep(2000);

        // Step 3: Click on "Mac"
        driver.findElement(By.linkText("Mac (1)")).click();
        Thread.sleep(2000);

        // Step 4: Select "Name (A - Z)" from Sort By dropdown
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");
        Thread.sleep(2000);

        // Step 5: Click on "Add to Cart"
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('41', '1');\"]")).click();
        Thread.sleep(3000);

        System.out.println("Mac added to cart successfully!");
    }

    @AfterMethod
    public void afterMethod() {
            driver.quit();

    }
}

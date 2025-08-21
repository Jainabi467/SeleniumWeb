package TestNg;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab9_1 {
	@Parameters("browser")
  @Test
	public void test2(@org.testng.annotations.Optional("chrome") String browser) throws InterruptedException {
	    WebDriver driver;
	    if(browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    } else if(browser.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    } else {
	        throw new IllegalArgumentException("Browser not supported: " + browser);
	    }

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://tutorialsninja.com/demo/index.php?");

	    driver.findElement(By.linkText("Desktops")).click();
	    driver.findElement(By.linkText("Mac (1)")).click();

	    WebElement sort = driver.findElement(By.id("input-sort"));
	    Select sle = new Select(sort);
	    sle.selectByIndex(1);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	    driver.findElement(By.xpath("//button/span[text()='Add to Cart']")).click();
	    driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mobile");
	    driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']//i[@class='fa fa-search']")).click();

	    Thread.sleep(3000);
	    WebElement cl = driver.findElement(By.id("input-search"));
	    cl.clear();
	    driver.findElement(By.id("description")).click();

	    driver.quit();
	}

}
package selenium_webdriver;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC002 {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	System.out.println("title is: "+driver.getTitle());
	WebElement search=driver.findElement(By.id("APjFqb"));
	search.sendKeys("Automation Testing Tools");
	search.sendKeys(Keys.ENTER);
	System.out.println("title is: "+driver.getTitle());
	//driver.findElement(By.name("btnK")).click();
		}

	}


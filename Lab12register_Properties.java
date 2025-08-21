package TestNg;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Lab12register_Properties {

	    public static void main(String[] args) throws IOException, InterruptedException {

	        // Load properties file
	        Properties prob = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\VICTUS\\OneDrive\\Desktop\\wipro\\selenium_webdriver\\Lab12Tg.properties");
	        prob.load(fis);

	        String url = prob.getProperty("url");

	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        driver.get(url);

	        // Click My Account
	        driver.findElement(By.xpath(prob.getProperty("myAccount"))).click();
	        

	        // Click Register
	        driver.findElement(By.xpath(prob.getProperty("register"))).click();

	        // Enter user details from property file
	        driver.findElement(getBy(prob.getProperty("firstnameLocator")))
	                .sendKeys(prob.getProperty("firstname"));
	        driver.findElement(getBy(prob.getProperty("lastnameLocator")))
	                .sendKeys(prob.getProperty("lastname"));
	        driver.findElement(getBy(prob.getProperty("emailLocator")))
	                .sendKeys(System.currentTimeMillis() + prob.getProperty("email")); // unique email
	        driver.findElement(getBy(prob.getProperty("telephoneLocator")))
	                .sendKeys(prob.getProperty("telephone"));
	        driver.findElement(getBy(prob.getProperty("passwordLocator")))
	                .sendKeys(prob.getProperty("password"));
	        driver.findElement(getBy(prob.getProperty("confirmPasswordLocator")))
	                .sendKeys(prob.getProperty("password"));

	        // Click Privacy Policy
	        driver.findElement(getBy(prob.getProperty("privacyPolicy"))).click();

	        // Click Continue
	        driver.findElement(By.xpath(prob.getProperty("continueBtn"))).click();

	        // Verify success message
	        WebElement success = driver.findElement(By.xpath(prob.getProperty("successMsg")));
	        if (success.isDisplayed()) {
	            System.out.println("✅ Account created successfully");
	        } else {
	            System.out.println("❌ Account creation failed");
	        }

	        Thread.sleep(3000);
	        driver.quit();
	    }

	    public static By getBy(String locator) {
	        if (locator == null) {
	            throw new IllegalArgumentException("Locator is null! Please check your properties file.");
	        }

	        if (locator.startsWith("//") || locator.startsWith("(//")) {
	            return By.xpath(locator);
	        } else if (locator.startsWith("css=")) {
	            return By.cssSelector(locator.substring(4));
	        } else if (locator.startsWith("id=")) {
	            return By.id(locator.substring(3));
	        } else if (locator.startsWith("name=")) {
	            return By.name(locator.substring(5));
	        } else {
	            throw new IllegalArgumentException("Unsupported locator: " + locator);
	        }
	    }

	  
	    }
	



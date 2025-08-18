package TestNg;


	

	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.BeforeClass;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.AfterSuite;

	public class Tg001_testNG {
		WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String username, String password) throws InterruptedException {
			String title=driver.getTitle();
			System.out.println("The Title is:"+title);
			Thread.sleep(3000);
			//WebElement username=driver.findElement(By.name("username"));
			//username.sendKeys("Admin");
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Before Method");
		  WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("after method");
		  driver.quit();
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	      new Object[] { "Pooja", "admin123" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("before classs");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("after class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("before test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("after test");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("before suit");
	  }
	  

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("After Suit");
	  }

	}



package TestNg;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.BeforeClass;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.AfterSuite;

	public class Lab8
	{
		WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) 
	  {
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  WebElement sort=driver.findElement(By.id("input-sort"));
		  Select sle=new Select(sort);
		  sle.selectByIndex(1);
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		  System.out.println("Run successfully");
	  }
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  System.out.println("Before Method");
		  WebDriverManager.chromedriver().setup(); 
		  driver=new ChromeDriver(); 
		  driver.get("https://tutorialsninja.com/demo/index.php?"); 
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
		  driver.quit();
	  }


	  @DataProvider
	  public Object[][] dp() 
	  {
	    return new Object[][] 
	    {
	      new Object[] { 1, "a" },
	      //new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() 
	  {
	  }

	  @AfterClass
	  public void afterClass() 
	  {
	  }

	  @BeforeTest
	  public void beforeTest() 
	  {
	  }

	  @AfterTest
	  public void afterTest() 
	  {
	  }

	  @BeforeSuite
	  public void beforeSuite() 
	  {
	  }

	  @AfterSuite
	  public void afterSuite() 
	  {
	  }

	
}

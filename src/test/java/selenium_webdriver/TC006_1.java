package selenium_webdriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	//import com.google.protobuf.Duration;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Lab6 {
		public static void main(String[] args) throws InterruptedException 
		{
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo/index.php?");
			Thread.sleep(3000);
			
			// Step 1 - Login With Credentials
			driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
			
			driver.findElement(By.id("input-email")).sendKeys("shaikjainabi06@gmailcom");
			driver.findElement(By.id("input-password")).sendKeys("Jainabi@623");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
			
			Thread.sleep(3000);
			
			// Step 2 - Go to 'Components' tab and click
			driver.findElement(By.linkText("Components")).click();
			
			// Step 3 - Select 'Monitors'
			driver.findElement(By.linkText("Monitors (2)")).click();
			
			// Step 4 - Select 25 from 'Show' drop down
			WebElement sort=driver.findElement(By.id("input-limit"));
			Select sle=new Select(sort);
			sle.selectByIndex(1);
			
			// Step 5 - Click on 'Add to cart' for the first item
			Thread.sleep(3000);
			WebElement AddToCart=driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]"));
			AddToCart.click();
			System.out.println("Product successfully added into cart!!");
			
			// Step 6 - Click on 'Specification' tab
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")).click();
			
			// Step 7 - Verify details present on the page
			WebElement cdetails=driver.findElement(By.id("tab-specification"));
			if(cdetails.isDisplayed() && !cdetails.getText().isEmpty())
			{
				System.out.println("Details displayed and verified");
				System.out.println(cdetails.getText());
			}
			else
			{
				System.out.println("Details is missing");
			}
			
			// Step 8 - Click on 'Add to Wish list' button.
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
			Thread.sleep(2000);
			
			// Step 9 - Verify message 'Success: You have added Apple Cinema 30" to your wish list!'
			WebElement wishlist = driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible"));
			String msg=wishlist.getText();
			
			Thread.sleep(3000);
		
			if(msg.contains("Success: You have added Apple Cinema 30\" to your wish list!"))
			{
				System.out.println("Correct wishlist msg:You have added Apple Cinema 30\\\" to your wish list!");
			}
			else
			{
				System.out.println("Wrong wishlist msg displayed.");
			}
			
			
			// Step 10 - Enter 'Mobile' in ' Search' text box.
			driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
			
			// Step 11 - Click on 'Search' button
			driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
			System.out.println("Entered mobile in search box");
			
			// Step 12 - Click on 'Search in product descriptions' check box
			driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
			System.out.println("clicked on product description checkbox");
			Thread.sleep(3000);
			
			driver.findElement(By.id("button-search")).click();
			
			// Step 13 - Click on link 'HTC Touch HD' for the mobile 'HTC Touch HD'
			driver.findElement(By.linkText("HTC Touch HD")).click();
			
			// Step 14 - Clear '1' from 'Qty' and enter '3'
			driver.findElement(By.id("input-quantity")).clear();
			driver.findElement(By.id("input-quantity")).sendKeys("3");
			
			// Step 15 - Click on 'Add to Cart' button
			driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
			System.out.println("Mobile HTC Touch HD added in cart");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Step 16 - Verify success message 'Success: You have added HTC Touch HD to your  shopping cart!'
			WebElement addCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
			String msg1=addCartMsg.getText();
			
			
			if(msg1.contains("Success: You have added HTC Touch HD to your shopping cart!"))
			{
				System.out.println("Correct msg: You have added HTC Touch HD to your shopping cart!");
			}
			else
			{
				System.out.println("Wrong wishlist msg displayed.");
			}
			
			
			// Step 17 - Click on 'View cart' button adjacent to search button
			driver.findElement(By.cssSelector("#cart > button")).click();
			driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1) > strong")).click();
			
			
			// Step 18 - Verify Mobile name added to the cart
			WebElement mobname=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));
			String mob=mobname.getText();
			
			if(mob.contains("HTC Touch HD"))
			{
				System.out.println("Mobile name is added to the cart");
			}
			else
			{
				System.out.println("Mobile name is not added to the cart");
			}
			
			
			// Step 19 - Click on 'Checkout' button
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
			System.out.println("Successfully clicked on checkout button");
			
			// Step 20 - Click on 'My Account' drop down
			driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
			
			// Step 21 - Select 'Logout' from drop down
			driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a")).click();
			
			// Step 22 - Verify 'Account Logout' heading
			if(driver.getPageSource().contains("Account Logout"))
			{
				System.out.println("Logout Successful");
			}
			else 
			{
				System.out.println("Logout Failed");
			}
			
			// Step 23 - Click on 'Continue'
			driver.findElement(By.linkText("Continue")).click();
			
		}

	}




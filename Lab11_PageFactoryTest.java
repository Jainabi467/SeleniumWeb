	package TestNg;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;
	
	public class Lab11_PageFactoryTest {
		    WebDriver driver;
		    WebDriverWait wait;

		    public Lab11_PageFactoryTest(WebDriver driver) {
		        this.driver = driver;
		        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    }

		    // Step 1 - Login
		    public void login(String email, String password) {
		        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		        driver.findElement(By.id("input-email")).sendKeys(email);
		        driver.findElement(By.id("input-password")).sendKeys(password);
		        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		    }

		    // Step 2 - Components -> Monitors
		    public void goToMonitors() {
		        driver.findElement(By.linkText("Components")).click();
		        driver.findElement(By.linkText("Monitors (2)")).click();
		    }

		    // Step 3 - Select from dropdown
		    public void selectShowLimit(int index) {
		        WebElement sort = driver.findElement(By.id("input-limit"));
		        new Select(sort).selectByIndex(index);
		    }

		    // Step 4 - Add first monitor to cart
		    public void addFirstMonitorToCart() {
		        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
		    }

		    // Step 5 - Specification
		    public String getSpecificationDetails() {
		        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")).click();
		        WebElement details = driver.findElement(By.id("tab-specification"));
		        return details.getText();
		    }

		    // Step 6 - Add to wishlist
		    public String addToWishlist() {
		        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
		        return driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();
		    }

		    // Step 7 - Search product
		    public void searchProduct(String product, boolean inDescription) {
		        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(product);
		        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		        if (inDescription) {
		            driver.findElement(By.id("description")).click();
		            driver.findElement(By.id("button-search")).click();
		        }
		    }

		    // Step 8 - Select HTC Touch HD and add qty
		    public void selectHTCAndAddToCart(String qty) {
		        driver.findElement(By.linkText("HTC Touch HD")).click();
		        driver.findElement(By.id("input-quantity")).clear();
		        driver.findElement(By.id("input-quantity")).sendKeys(qty);
		        driver.findElement(By.id("button-cart")).click();
		    }

		    public String getCartMessage() {
		        return wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.cssSelector("div.alert.alert-success.alert-dismissible"))).getText();
		    }

		    // Step 9 - Open cart and checkout
		    public String openCartAndGetMobileName() {
		        driver.findElement(By.cssSelector("#cart > button")).click();
		        driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1) > strong")).click();
		        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).getText();
		    }

		    public void checkout() {
		        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
		    }

		    // Step 10 - Logout
		    public boolean logout() {
		        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
		        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a")).click();
		        return driver.getPageSource().contains("Account Logout");
		    }

		    public void continueAfterLogout() {
		        driver.findElement(By.linkText("Continue")).click();
		    }
		}




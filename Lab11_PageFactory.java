package TestNg;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Lab11_PageFactory {
	    public static void main(String[] args) throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://tutorialsninja.com/demo/index.php?");

	        Lab11_PageObjectModel  obj = new Lab11_PageObjectModel(driver);

	        // Step 1 - Login
	        obj.login("shaikjainabi06@gmailcom", "Jainabi@623");

	        // Step 2 - Components -> Monitors
	        obj.goToMonitors();
	        obj.selectShowLimit(1);
	        obj.addFirstMonitorToCart();
	        System.out.println("Monitor added to cart!");

	        // Step 3 - Specification
	        System.out.println("Specification: " + obj.getSpecificationDetails());

	        // Step 4 - Wishlist
	        System.out.println("Wishlist message: " + obj.addToWishlist());

	        // Step 5 - Search Mobile
	        obj.searchProduct("Mobile", true);

	        // Step 6 - HTC product add to cart
	        obj.selectHTCAndAddToCart("3");
	        System.out.println(obj.getCartMessage());

	        // Step 7 - Open cart
	        System.out.println("Mobile in cart: " + obj.openCartAndGetMobileName());

	        // Step 8 - Checkout
	        obj.checkout();

	        // Step 9 - Logout
	        if (obj.logout()) {
	            System.out.println("Logout successful");
	        } else {
	            System.out.println("Logout failed");
	        }
	        obj.continueAfterLogout();

	        driver.quit();
	    }
	}




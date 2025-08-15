package selenium_webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005KeyUses {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php?");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		if(driver.findElement(By.id("email_create")).isDisplayed()) {
			System.out.println("email is created");
			driver.findElement(By.id("email_create")).clear() ;
			driver.findElement(By.id("email_create")).sendKeys("kdkumarone@gmail.com");
			driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
			driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		}
		else {System.out.println("not created");

	}Thread.sleep(3000);
	driver.findElement(By.id("id_gender1")).click();
	
	if(	driver.findElement(By.id("id_gender1")).isSelected())
	{
		System.out.println("gender1 is selected");
	}
	else
	{
		System.out.println("gender1 is not selected");
	}

}
}

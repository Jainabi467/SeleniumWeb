package selenium_webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_Alert {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert salert=driver.switchTo().alert();
		System.out.println("The message is " + salert.getText());
		salert.accept();
		
		
		
		driver.findElement(By.id("confirm")).click();
		Alert calert=driver.switchTo().alert();
		System.out.println("Confirm alert : "+calert.getText());
		calert.dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Alert palert=driver.switchTo().alert();
		System.out.println("prompt alert message is :"+palert.getText());
		palert.sendKeys("Hiii");
		palert.accept();
	}
}

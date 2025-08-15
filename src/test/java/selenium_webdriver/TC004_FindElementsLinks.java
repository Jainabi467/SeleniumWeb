package selenium_webdriver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TC004_FindElementsLinks {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver =new ChromeDriver();
driver.get("https://www.amazon.in/");
List<WebElement>l1=driver.findElements(By.tagName("a"));
System.out.println(l1.size());
for(WebElement link: l1) {
	//System.out.println(link);
	System.out.println(link.getAttribute("href"));
	System.out.println(link.getText());
}
}
}

package TestNg;

import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Lab15 {
    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "dp")
    public void f(String firstname, String lastname, String email, String telephone,
                  String password, String confirm) {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("telephone")).sendKeys(telephone);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirm")).sendKeys(confirm);

        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // Close browser after each test
    }

    @DataProvider
    //@DataProvider
    public Object[][] dp() throws IOException, CsvException {
        String csvFile = projectpath + "\\UserDetails.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        List<String[]> data = csvReader.readAll();

        int rowCount = data.size() - 1;  // Exclude header
        String[][] data1 = new String[rowCount][6]; // Force 6 columns

        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            for (int j = 0; j < 6; j++) {
                if (j < row.length) {
                    data1[i - 1][j] = row[j];
                } else {
                    data1[i - 1][j] = ""; // Fill missing columns
                }
            }
        }

        csvReader.close();
        return data1;
    }

}

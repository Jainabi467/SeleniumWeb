package TestNg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab14 {

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        FileInputStream fis = new FileInputStream(
            new File("C:\\Users\\VICTUS\\OneDrive\\Desktop\\wipro\\selenium_webdriver\\UserDetails.xlsx")  );
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    @Test(dataProvider = "userData")
    public void registerAccount(String firstName, String lastName, String email,String telephone, String password, String confirmPassword) 
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://tutorialsninja.com/demo/");

            WebElement myAccount = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
            myAccount.click();

            WebElement registerLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Register")));
            registerLink.click();

            // Filling the form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname"))).sendKeys(firstName);
            driver.findElement(By.id("input-lastname")).sendKeys(lastName);
            driver.findElement(By.id("input-email")).sendKeys(email);
            driver.findElement(By.id("input-telephone")).sendKeys(telephone);
            driver.findElement(By.id("input-password")).sendKeys(password);
            driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            WebElement successMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Account Has Been Created!']")));

            Assert.assertTrue(successMsg.isDisplayed(), "Account creation failed for: " + email);
            System.out.println("Account created successfully for: " + email);

        } catch (Exception e) {
            System.out.println("Error while registering " + email + ": " + e.getMessage());
        } 
            driver.quit();
        }
    
}

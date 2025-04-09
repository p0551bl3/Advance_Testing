package poly.testing.kethop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTestWithExcel {
    WebDriver driver;
    Workbook workbook;
    Sheet sheet;
    int rowIndex = 1;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Tạo workbook Excel và sheet
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Login Results");

        // Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Username");
        header.createCell(1).setCellValue("Password");
        header.createCell(2).setCellValue("Result");
        header.createCell(3).setCellValue("Timestamp");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        boolean loginSuccess;
        try {
            loginSuccess = driver.findElement(By.className("title")).isDisplayed();
        } catch (Exception e) {
            loginSuccess = false;
        }

        // Ghi vào Excel
        Row row = sheet.createRow(rowIndex++);
        row.createCell(0).setCellValue(username);
        row.createCell(1).setCellValue(password);
        row.createCell(2).setCellValue(loginSuccess ? "PASS" : "FAIL");
        row.createCell(3).setCellValue(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
        );

        if (loginSuccess) {
            driver.findElement(By.id("react-burger-menu-btn")).click();
            driver.findElement(By.id("logout_sidebar_link")).click();
        }
    }

    @AfterClass
    public void tearDown() throws IOException {
        driver.quit();

        // Auto-size cột và lưu file
        for (int i = 0; i < 4; i++) sheet.autoSizeColumn(i);

        FileOutputStream out = new FileOutputStream("login-results.xlsx");
        workbook.write(out);
        out.close();
        workbook.close();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"invalid_user", "wrong_pass"}
        };
    }
}

package poly.testing.lab6;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;

public class LoginTestWithExcel {

    @BeforeAll
    public static void xinChaoTest() {
        System.out.println("Hello baby");
    }

    public static void main(String[] args) {
        // Khởi tạo Workbook và Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Kết quả kiểm thử");

        // Tiêu đề cột
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("STT");
        header.createCell(1).setCellValue("Tên testcase");
        header.createCell(2).setCellValue("Kết quả");

        // Test case: Login thành công
        String result1 = testLogin("tomsmith", "SuperSecretPassword!");
        writeResultToSheet(sheet, 1, "Login thành công", result1);

        // Test case: Login thất bại
        String result2 = testLogin("tomsmith", "sai_mat_khau");
        writeResultToSheet(sheet, 2, "Login thất bại", result2);

        // Ghi file Excel ra ổ đĩa
        try (FileOutputStream fos = new FileOutputStream("ketqua_kiemthu.xlsx")) {
            workbook.write(fos);
            workbook.close();
            System.out.println("✅ Kết quả đã được ghi vào file Excel.");
        } catch (IOException e) {
            System.out.println("❌ Lỗi khi ghi file Excel: " + e.getMessage());
        }
    }

    public static String testLogin(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe"); // cập nhật đường dẫn thực tế
        WebDriver driver = new ChromeDriver();
        String result = "";

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.className("radius")).click();

            // Kiểm tra kết quả login
            WebElement message = driver.findElement(By.cssSelector(".flash"));

            if (message.getText().contains("You logged into a secure area!")) {
                result = "PASS";
            } else {
                result = "FAIL";
            }

        } catch (Exception e) {
            result = "ERROR";
        } finally {
            driver.quit();
        }

        return result;
    }

    public static void writeResultToSheet(Sheet sheet, int rowNum, String testName, String result) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(rowNum);
        row.createCell(1).setCellValue(testName);
        row.createCell(2).setCellValue(result);
    }
}


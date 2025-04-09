package poly.testing.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLocatorsTest {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // ➤ 1. Tìm bằng ID
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("student");

            // ➤ 2. Tìm bằng Name
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("Password123");

            // ➤ 3. Tìm bằng ClassName
            WebElement loginBtn = driver.findElement(By.className("btn"));
            loginBtn.click();

            // ➤ 4. Kiểm tra kết quả bằng CSS Selector
            WebElement successMsg = driver.findElement(By.cssSelector(".post-title"));
            if (successMsg.getText().contains("Logged In Successfully")) {
                System.out.println("✅ Đăng nhập thành công!");
            } else {
                System.out.println("❌ Đăng nhập thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

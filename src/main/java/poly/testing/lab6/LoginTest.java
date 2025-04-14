package poly.testing.lab6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Đặt đường dẫn tới ChromeDriver nếu cần
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang login
            driver.get("https://the-internet.herokuapp.com/login");

            // Dùng các loại locators khác nhau
            WebElement usernameField = driver.findElement(By.id("username"));          // by ID
            WebElement passwordField = driver.findElement(By.name("password"));        // by Name
            WebElement loginButton   = driver.findElement(By.className("radius"));     // by ClassName

            // Điền thông tin và đăng nhập
            usernameField.sendKeys("tomsmith");
            passwordField.sendKeys("SuperSecretPassword!");
            loginButton.click();

            // Kiểm tra đăng nhập thành công bằng CSS Selector
            WebElement message = driver.findElement(By.cssSelector(".flash.success"));

            // In ra kết quả
            if (message.getText().contains("You logged into a secure area!")) {
                System.out.println("Login thành công!");
            } else {
                System.out.println("Login thất bại!");
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
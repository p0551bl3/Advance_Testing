package poly.testing.kethop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); // Chỉ định đường dẫn đến Chrome


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }


    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expectedResult) {
        // Nhập username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys(username);

        // Nhập password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        // Nhấn nút Đăng nhập
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        // Kiểm tra kết quả
        boolean loginSuccess = driver.getCurrentUrl().contains("logged-in-successfully");
        Assert.assertEquals(loginSuccess, expectedResult, "Login test failed!");

    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"student", "Password123", true},   // Đúng
                {"student", "wrongpass", false}, // Sai mật khẩu
                {"unknown", "Password123", false}, // Sai username
                {"", "", false}  // Để trống
        };
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


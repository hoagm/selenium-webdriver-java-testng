package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Button {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Button () {
        driver.get("https://www.fahasa.com/customer/account/create");
        By registerButton = By.cssSelector("button.fhs-btn-register");

        // 1, Clickable
        // chờ cho 1 element ko được phép click trong 10s
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(registerButton)));

        // 2. Text hiển thị đúng
        Assert.assertEquals(driver.findElement(registerButton).getText().trim(), "Đăng Ký");

        // 3. Background màu gì
        String backgroundElement = driver.findElement(registerButton).getCssValue("background-color");
        System.out.println(backgroundElement);
        Assert.assertEquals(backgroundElement, "rgba(0, 0, 0, 0)");
        // nên convert mã màu sang hexa để phù hợp vs mã màu của tất cả các trình duyệt
        Color.fromString(backgroundElement).asHex();
        Assert.assertEquals(Color.fromString(backgroundElement).asHex().toUpperCase(), "#000000");

        // 4. Disable/ Enable
        // Mong đợi element enable thì assertTrue và ngược lại diasble- assertFalse
        Assert.assertFalse(driver.findElement(registerButton).isEnabled());

    }
    @Test
    public void TC_02_Fahasa () {
        driver.get("https://www.fahasa.com/customer/account/create");

        WebElement buttonLogin = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        String buttonLoginColor = buttonLogin.getCssValue("background-color");

        // step 2
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        // step 3
        Assert.assertFalse(buttonLogin.isEnabled());

        // step 4
        Assert.assertEquals(Color.fromString(buttonLoginColor).asHex().toUpperCase(), "#e0e0e0");

        // step 5
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0123456789");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("a123456");

        // step 6
        Assert.assertTrue(buttonLogin.isEnabled());

        // step 7
        Assert.assertEquals(Color.fromString(buttonLoginColor).asHex().toUpperCase(), "#C92127");



    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

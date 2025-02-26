package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Fixed_popup {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions actions;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Fixed_Not_Found_in_DOM () throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        By popupDialog = By.cssSelector("div#custom-dialog div[role='dialog']");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        // kiểm tra popup hiển thị
        Assert.assertTrue(driver.findElement(popupDialog).isDisplayed());

        // điền thông tin
        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("automation");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("1233456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='custom-dialog'] //button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.xpath("//h2[text()='Đăng nhập']//button")).click();
        Thread.sleep(2000);

        // do popup đã ko cồn hiển thị trong HTML nên ko thể dùng hàm display để verify
        // findElement chỉ trẩ về 1 element, khi ko tìm thấy thì nó fail
        // findElements trả về 1 list element, và khi ko tìm thấy nó trả về = 0
        Assert.assertEquals(driver.findElements(popupDialog).size(), 0);


    }

    @Test
    public void TC_02_Fixed_in_DOM () throws InterruptedException {
        driver.get("https://www.zingpoll.com/");

        driver.findElement(By.cssSelector("a#Loginform")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div#Login")).isDisplayed());
        driver.findElement(By.cssSelector("div#Login button.close")).click();
        Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.cssSelector("div#Login")).isDisplayed());
    }

    @Test
    public void TC_03_Fixed_in_DOM () throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.modal-content div.right")).isDisplayed());

        //step 3
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("1233456");

        // Step 4
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(2000);

        // Step 5
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_04_Fixed__NOT_in_DOM () throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        driver.findElement(By.cssSelector("login-with-email")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']//parent::div//following-sibling::span")),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']//parent::div//following-sibling::span")),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("button.btn-close")).click();
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);



    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

//        driver.quit();
    }

}

package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Register {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

            driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }

    // 2- Action/ Execute
    @Test
    public void Register_01_Empty_Data () {
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();


        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }
    @Test
    public void Register_02_Invalid_Email () {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.id("txtEmail")).sendKeys("123@123..");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@123..");
        driver.findElement(By.id("txtPassword")).sendKeys("john@vn");
        driver.findElement(By.id("txtCPassword")).sendKeys("john@vn");
        driver.findElement(By.id("txtPhone")).sendKeys("0912345678");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");



    }
    @Test
    public void Register_03_Incorrect_Confirm_Email () {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuyen@my");
        driver.findElement(By.id("txtPassword")).sendKeys("john@vn");
        driver.findElement(By.id("txtCPassword")).sendKeys("john@vn");
        driver.findElement(By.id("txtPhone")).sendKeys("0912345678");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void Register_04_Invalid_Password () {

        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtPassword")).sendKeys("@vn");
        driver.findElement(By.id("txtCPassword")).sendKeys("@vn");
        driver.findElement(By.id("txtPhone")).sendKeys("0912345678");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void Register_05_Incorrect_Confirm_Passwpod () {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtPassword")).sendKeys("123@vn");
        driver.findElement(By.id("txtCPassword")).sendKeys("321@vn");
        driver.findElement(By.id("txtPhone")).sendKeys("0912345678");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Invalid_Phone_Number () {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuyen@anh");
        driver.findElement(By.id("txtPassword")).sendKeys("123@vn");
        driver.findElement(By.id("txtCPassword")).sendKeys("123@vn");

        // ko bắt đầu = 0
        driver.findElement(By.id("txtPhone")).sendKeys("912345678");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        // < 10 số
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0123");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // >11 số
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0123456789100");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // gồm chữ cái
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0123a456789");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập con số");

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

//        driver.quit();
    }

}

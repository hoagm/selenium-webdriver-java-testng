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
        driver.findElement(By.id("txtEmail")).sendKeys("Nguyễn Văn A");
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");



    }
    @Test
    public void Register_03_Incorrect_Confirm_Email () {


    }
    @Test
    public void Register_04_Invalid_Password () {


    }
    @Test
    public void Register_05_Incorrect_Confirm_Passwpod () {


    }
    @Test
    public void Register_06_Invalid_Phone_Number () {


    }
    @Test
    public void Register_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

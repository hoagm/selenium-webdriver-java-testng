package webDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Alert {

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
    public void TC_01_Accept_Alert () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // wait alert xuất hiện
        // trong hàm alertIsPresent đã có sẵn câu lệnh để switch qua alert => ko cần lệnh switch to nữa
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");


        // switch vào alert mà kko dùng wait
//        driver.switchTo().alert().accept();

        // cancel alert
//        driver.switchTo().alert().dismiss();

        // get text ra để verify
//        driver.switchTo().alert().getText();

        // nhập text vào rồi acccept
//        driver.switchTo().alert().sendKeys("");
    }

    @Test
    public void TC_02_Confirm_Alert () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        String name = "auto";
        alert.sendKeys(name);
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + name);
    }

    @Test
    public void TC_04_Authentication_Alert () {
        String username = "admin";
        String password = "admin";

        // cách 1: truyền thẳng vào URL
//        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.get("http://"+ username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");

        // cách 2: ko  thể trực tiếp gán user và pas vào

        driver.get("http://the-internet.herokuapp.com/basic_auth");

        String authenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getDomProperty("href");
        driver.get(passUserAuthenLink(authenLink, username, password));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

    }

    public String passUserAuthenLink(String authenLink, String username, String password) {

        String[] text = authenLink.split("//");
        return text[0] + "//" + username + ":" + password  + "@" + text[1];

    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

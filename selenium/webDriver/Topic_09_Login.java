package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Login {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        driver.get("https://live.techpanda.org/index.php/");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Empty () {
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");

    }
    @Test
    public void TC_02_Invalid () {
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("123434234@1234.1234");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void TC_03_Short_Password () {
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Incorrect () {
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");



    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

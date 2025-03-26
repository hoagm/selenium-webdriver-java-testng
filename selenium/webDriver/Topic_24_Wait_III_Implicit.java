package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_III_Implicit {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeMethod
    public void initialBrowser() {
        driver = new  ChromeDriver();

        // cần run test các trường hợp driver.get trong từng test case
        driver.get("https://automationfc.github.io/dynamic-loading/");

    }

    // 2- Action/ Execute
    @Test(description = "thời gian implicit = 0")
    public void TC_00 () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }

    @Test(description = "thời gian implicit ngắn hơn thời gian element xuất hiện")
    public void TC_01 () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }

    @Test(description = "thời gian implicit = thời gian element xuất hiện")
    public void TC_02 () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    @Test(description = "thời gian implicit dài hơn thời gian element xuất hiện")
    public void TC_03 () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }


    // 3- Clean
    @AfterMethod
    public void cleanBrowser() {

        driver.quit();
    }

}

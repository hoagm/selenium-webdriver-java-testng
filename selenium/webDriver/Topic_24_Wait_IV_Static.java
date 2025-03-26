package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_Wait_IV_Static {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new  ChromeDriver();

        // cần run test các trường hợp driver.get trong từng test case
        driver.get("https://automationfc.github.io/dynamic-loading/");

    }

    // 2- Action/ Execute
    @Test(description = "thời gian = 0")
    public void TC_00 () throws InterruptedException {

        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInSecond(0);
        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }

    @Test(description = "thời gian ngắn hơn thời gian element xuất hiện")
    public void TC_01 () {
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInSecond(3);

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");


    }

    @Test(description = "thời gian = thời gian element xuất hiện")
    public void TC_02 () {
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInSecond(5);

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    @Test(description = "thời gian dài hơn thời gian element xuất hiện")
    public void TC_03 () {
        // step 1: click buttoon start
        driver.findElement(By.cssSelector("div#start>button")).click();
        sleepInSecond(10);

        // loading icon xuất hiện trong 5s

        // step2: hello world xuất hiện -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    public void sleepInSecond (long timeInSecond){

        // sleep cứng, ko quan tâm có tìm ra hay ko, phải chờ cho hết thời gian đã xét
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

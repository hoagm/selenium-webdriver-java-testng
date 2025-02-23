package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_P1 {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Giang My Hoa\\AppData\\Local\\Google\\Chrome\\User Data");
        chromeOptions.addArguments("--profile-directory=Profile 4");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();

        action = new Actions(driver);


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_JQuery () throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).pause(Duration.ofSeconds(3)).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");



    }
    @Test
    public void TC_02_Myntra () throws InterruptedException {
        driver.get("https://www.myntra.com/");

        action.moveToElement(driver.findElement(By.xpath("//a[text()='Kids']/parent::div/parent::div"))).pause(Duration.ofSeconds(3)).perform();

        action.click(driver.findElement(By.xpath("//a[text()='Home & Bath']"))).perform();
        Thread.sleep(3000);

    }

    @Test
    public void TC_03_Fahasa () throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        Thread.sleep(5000);

        action.moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'fhs_center_right')]"))).pause(Duration.ofSeconds(3)).perform();
        action.moveToElement(driver.findElement(By.xpath("//span[text()='VPP - Dụng Cụ Học Sinh']"))).pause(Duration.ofSeconds(3)).perform();
        action.click(driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')] //a[text()='Thước']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(), "THƯỚC");

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

//        driver.quit();
    }

}

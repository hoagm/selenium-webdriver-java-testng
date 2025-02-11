
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

public class Topic_07_Browser_Excercise {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Page_URL () {
        driver.get("https://live.techpanda.org/");

        //click My account in footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //1
//        String loginURL = driver.getCurrentUrl();
//        Assert.assertEquals(loginURL, "https://live.techpanda.org/index.php/customer/account/login/");

        //2
        // tuyet doi
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
//
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");



    }
    @Test
    public void TC_02_Page_Title () {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        Assert.assertEquals(driver.getTitle(), "Customer Login");

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void TC_03_Page_Navigate () {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title=\"My Account\"]")).click();
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

        // back lai trang trc
        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        // forward trang

        driver.navigate().forward();

        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_04_Page_Source () {
        driver.get("https://live.techpanda.org/");


        driver.findElement(By.cssSelector("div.footer a[title=\"My Account\"]")).click();

        // tuong doi = assertTrue/False
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));


    }

    public void TC_05_Page_Title () {


    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

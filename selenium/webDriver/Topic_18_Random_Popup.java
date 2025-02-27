package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Random_Popup {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Random_In_DOM () throws InterruptedException {
        driver.get("https://dehieu.vn/");
        Thread.sleep(5000);

        By popup = By.cssSelector("div.modal-content");

        // TH 1: pop up hiển thị -> close popup và click đăng nhâp
        // TH 2: pop up ko hiển thị -> click đăng nhâp

        if (driver.findElement(popup).isDisplayed()) {
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(2000);

        }

        driver.findElement(By.xpath("//a[text()=' Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.b-login")).isDisplayed());

    }

    @Test
    public void TC_02_Fixed_in_DOM () throws InterruptedException {
        driver.get("https://www.kmplayer.com/");
        By popup = By.cssSelector("div#layer2");
        Thread.sleep(3000);

        if (driver.findElement(popup).isDisplayed()) {
            driver.findElement(By.cssSelector("div.close")).click();
            Thread.sleep(3000);
        }

        action.moveToElement(driver.findElement(By.cssSelector("li[class='pc pc64x']"))).perform();
        driver.findElement(By.xpath("//li[@class='pc']/a[text()='KMPlayer']']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.sub h1")).getText(),"KMPlayer - Video Player for PC");

    }

    @Test
    public void TC_03_Fixed_in_DOM () throws InterruptedException {

    }

    @Test
    public void TC_04_Fixed_NOT_in_DOM () throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");
        Thread.sleep(7000);

        By popup = By.xpath("//div[starts-with(@data-title,'Newsletter') and @data-page='1']");// doo trang này có 2 loại popup start with Newsletter

        // do kko cos trong DOM neen laays size
        if (!driver.findElements(popup).isEmpty() && driver.findElements(popup).get(0).isDisplayed()) {
            driver.findElement(By.xpath("//div[starts-with(@data-title,'Newsletter') and @data-page='1']//a[text()='×']")).click();
            Thread.sleep(3000);
        }

//        if (driver.findElements(popup).size() > 0 && driver.findElements(popup).get(0).isDisplayed()) {
//            driver.findElement(By.xpath("//div[starts-with(@data-title,'Newsletter') and @data-page='1']//a[text()='×']")).click();
//            Thread.sleep(3000);
//        }

        driver.findElement(By.cssSelector("input#search-input")).sendKeys("selenium");
        driver.findElement(By.cssSelector("button#search-submit")).click();

        List<WebElement> articles = driver.findElements(By.cssSelector("h2.post-title"));

        for (WebElement article : articles) {
            System.out.println(article.getText());
        }
    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

//        driver.quit();
    }

}

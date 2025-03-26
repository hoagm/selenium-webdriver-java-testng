package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_I_Element_Status {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Visible () throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        // điều kiện 1: element có trong UI và HTML => Visible
        //Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        // hàm để chờ cho element hiển thị (Visible/ display)
        expliciWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[name ='tel']")));

        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());


    }
    @Test
    public void TC_02_Invisible_HTML () throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        Thread.sleep(5000);

        // element KO hiển thị trên UI là đc (có hay ko trong HTML ko quan trọng)
        // => Invisible/ Undisplay

        expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));

    }
    @Test
    public void TC_02_Invisible_Not_HTML () throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        // Element ko có trên cả UI và HTML
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        // Lý do chạy lâu => phải đi tìm element trước=> ko có trog HTML
        // => phải tìm rất lâu, tìm đi tìm lại cho đến khi hết thời gian chờ ở dòng code 25
        expliciWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[name ='tel']")));

    }

    @Test
    public void TC_03_Presence () throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        Thread.sleep(5000);

        // chỉ cần CÓ trong HTML là đc (ko quan tâm UI)
        expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));

    }

    @Test
    public void TC_04_Staleness () throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        // Element ko có trong HTML
        // Điều kiện cần: invisible not in HTML
        // Điều kiện đủ: Element tại thười điểm A có trong HTML (Presence) và sau đó tại thời điểm B kiểm tra thì ko có nữa

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        // phone text box xuất hiện
        WebElement phoneTextbox = driver.findElement(By.cssSelector("input[name ='tel']"));

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        // tới đây phone text box ko còn trong HTML nữa => wait stanleness là đúng
        expliciWait.until(ExpectedConditions.stalenessOf(phoneTextbox));

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

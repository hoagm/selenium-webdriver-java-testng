package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Iframe {

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
    public void TC_01_ () {
        // A chứa iframe B
        driver.get("https://embedgooglemap.net/");


//        driver.switchTo().frame(0); // switch vào iframe dùng index sẽ bắt đầu từ 0 -> id dễ bị thay đổi -> ko nên dùng
//        driver.switchTo().frame(""); // dùng name hoặc id, n có cái có id/name, có cái ko => ko nên dùng
//        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv button iframe"))); // nên dùng element vì nó linh động

        // switch vào iframe B
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.gmap_canvas>iframe"))); // nên dùng element vì nó linh động

        // đang ở B lấy ra element trong B
        String address = driver.findElement(By.cssSelector("div.address")).getText();
        System.out.println(address);

        // B chứa  iframe C
        // switch vào iframe C
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv>div>div>iframe"))); // iframe số 2

        // đang ở C
        System.out.println(driver.getPageSource());

        // switch về B
        driver.switchTo().parentFrame();

        // B quay lai A
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("div.light input")).clear();
        driver.findElement(By.cssSelector("div.light input")).sendKeys("vietnam");




    }
    @Test
    public void TC_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}

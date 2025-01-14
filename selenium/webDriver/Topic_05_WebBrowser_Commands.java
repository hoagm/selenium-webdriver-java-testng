package webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        // tuowng tác vs Browser thông qua driver
        driver = new FirefoxDriver();

        System.out.println("Driver ID = " + driver.toString());

//        driver.get("https://www.facebook.com/");


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Browser() throws MalformedURLException {
        // Mở 1 URL bất kỳ
        driver.get("https://live.techpanda.org/");

        // đóng browser ko quan tâm có bn tab
//        driver.quit();
        // chỉ đóng tab hiện tại
//        driver.close();

        // tìm 1 element vs locator là tham số truyền vào
//        driver.findElement(By.cssSelector(""));
        // tìm nhiều element vs locator là tham số truyền vào
//        driver.findElements(By.cssSelector(""));


        // sử dụng luôn ko cần lưu trữ url
//        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/");

        // lấy ra title ở page hiện tại
        driver.getTitle();
        System.out.println("title = " + driver.getTitle());

        // lấy ra window 10 ở page hiện tại
        driver.getWindowHandle();
        System.out.println("window ID = " + driver.getWindowHandle());

        // lấy url của page hện tại và sử dụng ở step 10
        String homepageURL = driver.getCurrentUrl();

        // step 10
//        driver.get(homepageURL);
//        Assert.assertEquals(homepageURL, "https://live.techpanda.org/");

        driver.getPageSource();
        System.out.println("Page source code = " + driver.getPageSource());

        // Alert- Frame/iFrame - Window/tab

        //Alert:
        driver.switchTo().alert();

        //Frame-iFrame
        // switch vaof frame/iframe
        driver.switchTo().frame("");

        // switch ra trang cha ( quay laij ko vaof frame)
        driver.switchTo().defaultContent();

        // switch từ frame con ra frame cha ( nhiều frame lồng nhau)
        driver.switchTo().parentFrame();

        //window
        driver.switchTo().window("");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.facebook.com/");

        // set timeout để tìm element- implicitlyWait chỉ áp dụng cho 2 hàm là findElement và findElements
        // nanosecond < milisecond < second
        // trường hợp ko tìm thấy sẽ chờ đến timeout mới show ra lỗi ko tìm thấy
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(30));

        // set timeout để chờ page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // set timeout để chờ đoạn code js được thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        driver.manage().getCookies();
//        driver.manage().addCookie();

        // browser: full screen (F11)- maximize- minimize(ẩn xuống taskbar)
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // set kich thước (responsive)
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().getSize();

        // set browser tại vị trí nào
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();


        // seleniums log: browser/ drivers/ network
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.DRIVER);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().get(LogType.SERVER);
        driver.manage().logs().getAvailableLogTypes();

        //quay laij trang trc đó- chuyển tiếp đến trang trc đó -refresh - mở url
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));



    }
    @Test
    public void TC_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

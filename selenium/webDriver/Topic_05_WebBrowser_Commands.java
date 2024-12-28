package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrowser_Commands {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // tuowng tác vs Browser thông qua driver


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Browser() {
        // Mở 1 URL bất kỳ
        driver.get("https://live.techpanda.org/");

        // đóng browser ko quan tâm có bn tab
        driver.quit();
        // chỉ đóng tab hiện tại
        driver.close();

        // tìm 1 element vs locator là tham số truyền vào
        driver.findElement(By.cssSelector(""));
        // tìm nhiều element vs locator là tham số truyền vào
        driver.findElements(By.cssSelector(""));


        // sử dụng luôn ko cần lưu trữ url
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/");

        // lấy ra title ở page hiện tại
        driver.getTitle();

        // lấy ra window 10 ở page hiện tại
        driver.getWindowHandle();

        // lấy url của page hện tại và sử dụng ở step 10
        String homepageURL = driver.getCurrentUrl();

        // step 10
        driver.get(homepageURL);
        Assert.assertEquals(homepageURL, "https://live.techpanda.org/");




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

package webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_06_WebElement_Commands {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        // tuowng tác vs Browser thông qua driver
        driver = new FirefoxDriver();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Element() {
        // Tương tác trực tiếp
        driver.findElement(By.cssSelector(""));

        // Tương tác nhiều lần lên 1 element
        WebElement element  = (WebElement) driver.findElements(By.cssSelector("input#id"));

        // xoas dữ liệu trong 1 editable element
        element.clear();

        // Nhập dữ liệu vào editable element
        element.sendKeys("");


        // element cha dùng 1 loại locator- element con dùng 1 loại locator
        element.findElement(By.cssSelector("div.input-box")).
                findElement(By.xpath("//input[@id='middlename']"))   ;

        // element con và cha cùng chung 1 locator
        element.findElement(By.cssSelector("div.input-box input#middlename"));

        // click lên các element clickable
        element.click();

        // tương  đương vs  submit thông tin lên serve
        element.submit();

        // kiểm tra element có hiển thị hay ko
        // verify thông tin data đã action
        // áp dụng cho tất cả các element
        element.isDisplayed();

        // kiêm tra 1 cái element đã đc chọn hay chưa
        //  áp dụng cho checkbox/radio/dropdown
        element.isSelected();

        // kiểm tra 1 element có cho  phép thao tác lên hay ko
        element.isEnabled();


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

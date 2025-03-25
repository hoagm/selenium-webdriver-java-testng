package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_24_Wait_PII_Find_Element {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_FindElement () {

        // tìm thấy 1 element
        // vào sẽ tìm thấy element ngày, ko cần chờ đến hết timeout của Implicit
        driver.findElement(By.cssSelector("input#email"));

        // tìm thấy 0 element
        // vào sẽ ko tìm thấy element và sẽ tìm đi tìm lại cho đến khi hết timeout là 10s = 20 lần tìm (tìm mỗi 0,5s)
        driver.findElement(By.cssSelector("input#emailAddress"));

        // element last name ở trang đăng ký
        driver.findElement(By.cssSelector("input#lastname"));

        // tìm thấy nhiều hơn 1 element
        // Nó sẽ luôn thao tác vs element đầu tiên
        driver.findElement(By.cssSelector("input:not([type='hidden'])")).sendKeys("selenium");

    }

    @Test
    public void TC_02_FindElements () {
        // tìm thấy 1 element
        // Trả về 1 element + ko cần chờ hết timeout
        List<WebElement> elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println(elementList.size());

        // tìm thấy 0 element
        // vào sẽ ko tìm thấy element và sẽ tìm đi tìm lại cho đến khi hết timeout là 10s = 20 lần tìm (tìm mỗi 0,5s)
        // ko đánh fail test case mà trả về 1 list rỗng
        List<WebElement> OelementList = driver.findElements(By.cssSelector("input#emailAddress"));
        System.out.println(OelementList.size());

        // tìm thấy nhiều hơn 1 element
        // lấy hết tất cả lưu vào list
        List<WebElement> elementsList = driver.findElements(By.cssSelector("input:not([type='hidden'])"));
        System.out.println(elementsList.size());

        elementsList.get(1).sendKeys("autotest");

    }


    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

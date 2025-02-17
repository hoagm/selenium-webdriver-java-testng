package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_11_Default_Dropdown {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Select select;

    @BeforeClass
    public void initialBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () throws InterruptedException {
        driver.get("https://egov.danang.gov.vn/reg");
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_tinhthanh")));
        select.selectByVisibleText("thành phố Hà Nội");
        Thread.sleep(3000);

        // lấy ra item vừa chọn và verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"thành phố Hà Nội");

        // kiểm tra 1 dropdown là single hay multiple

        Assert.assertFalse(select.isMultiple());




    }
    @Test
    public void TC_02_ () {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

    }

    @Test
    public void TC_03_Dropdown_List2 () throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");
        // do teen class hoiw chung chung neen laays theo text
//        driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(3000);


        List<WebElement> dealers = driver.findElements(By.cssSelector("div.dealer_branch h4"));
        Assert.assertEquals(dealers.size(),16);

        // ham for-each trong java
        for (WebElement dealerName : dealers) {
            System.out.println(dealerName.getText());
        }


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

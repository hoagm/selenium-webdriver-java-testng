package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {

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
    public void TC_01_ () throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // Tìm dropdown
        // click vào dropdown
        // xổ ra hết item
        // click và item cần chọn
        driver.findElement(By.cssSelector("span#salutation-button")).click();
        Thread.sleep(2000);

        // chờ cho tất cả các item load/ xổ hết ra?
        // Cách chờ linh động, ko chờ cứng bằng thread.sleep
        // Bắt buộc phải lấy thẻ chứa text do mình đang dùng getText

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#salutation-menu div")));

        // tìm và lấy ra các item bên trong và lưu vào 1 biến( kiểu data là list)
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#salutation-menu div"));

        // Duyệt qua từng element để ktra vs điều kiện nếu text của item = cái mình mong thì click vào chính thằng đó
        for (WebElement item : allItems) {
            if (item.getText().equals("Dr.")) {
                item.click();
                break;
            }
        }


        // mục đích của viết hàm dể dễ tái sự dung, dễ maintence, dễ dàng thêm mới, dễ đọc



    }
    @Test
    public void TC_02_Jquery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // Viết hàm (reusable function)
        // tham số truyền vào: parameter
        // mục đích của viết hàm dể dễ tái sự dung, dễ maintainance, dễ dàng thêm mới, dễ đọc
        // gọi hàm

        // chọn title
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Mr.");
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Prof.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Prof.");

        // chọn speed
        selectItemInDropdown("span#speed-button", "ul#speed-menu div", "Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Slow");
    }
    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInDropdown("div.dropdown", "div[class='visible menu transition']", "Angola");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Angola.");



        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("div.dropdown", "div.item>span.text", "Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Matt.");





    }
    private void selectItemInDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);

        // chờ cho tất cả các item load/ xổ hết ra?
        // Cách chờ linh động, ko chờ cứng bằng thread.sleep
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        // tìm và lấy ra các item bên trong và lưu vào 1 biến( kiểu data là list)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        // Duyệt qua từng element để ktra vs điều kiện nếu text của item = cái mình mong thì click vào chính thằng đó
        for (WebElement item : allItems) {
            if (item.getText().equals(textItem)) {
                item.click();
                break;
            }
        }
    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

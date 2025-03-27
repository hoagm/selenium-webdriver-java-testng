package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_V_Explicit_III {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait explicitWait;

    String projectPath = System.getProperty("user.dir");
    String uploadFilePath = projectPath + "\\uploadFiles\\";

    String img1 = "01.jpg";
    String img2 = "02.jpg";
    String img3 = "03.jpg";

    String img1Path = uploadFilePath + img1;
    String img2Path = uploadFilePath + img2;
    String img3Path = uploadFilePath + img3;
    @BeforeClass
    public void initialBrowser() {
        driver = new  ChromeDriver();
    }

    // 2- Action/ Execute

    @Test
    public void TC_01_Telerik () {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // chờ date time hiển thị
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        // in ra ngày đã chọn-> hiện chưa chọn 
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.RadAjaxPanel>span"), "No Selected Dates to display."));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.RadAjaxPanel>span")).getText(), "No Selected Dates to display.");

        // wait để click vào ngày tháng năm
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='26']")));

        // click chọn ngày hiện tại
        driver.findElement(By.xpath("//td/a[text()='26']")).click();

        // cách 1 : wait loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
        // hoặc tìm cái ko phải là display none
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div:not([style='display:none;'])>div.raDiv")));

        // wait text được update
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.RadAjaxPanel>span"), "Wednesday, March 26, 2025"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.RadAjaxPanel>span")).getText(), "Wednesday, March 26, 2025");

        // wait ngày được chọn đã đc selected
        // vì đây là thẻ a, ko phải radio button/ checkbbox nên ko thể dùng selectedBy
        // -> check dựa trên attribute được thêm vào là class "rcSelected"
        explicitWait.until(ExpectedConditions.attributeToBe(By.xpath("//td/a[text()='26']/parent::td"), "class", "rcSelected"));
        Assert.assertEquals(driver.findElement(By.xpath("//td/a[text()='26']/parent::td")).getDomAttribute("class"), "rcSelected");

    }

    @Test
    public void TC_02_Upload_File () {
        driver.get("https://gofile.io/home");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // wait cho tất cả loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#index_loader"))));

        //  load file lên
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(img1Path + "\n" + img2Path + "\n" + img3Path);

        // wait icon loading dưới destination biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span#destinationFolder")));

        // wait đến khi tất cả thanh bar loading biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress-container"))));

        // wait đến khi hiển thị thông báo complete
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.text-center>h2"), "Upload Complete"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text-center>h2")).getText(), "Upload Complete");

        // lấy link folder đã upload ảnh
        String link = driver.findElement(By.cssSelector("a.linkSuccessCard")).getDomAttribute("href");
        driver.get(link);




    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

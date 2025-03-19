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

public class Topic_23_Upload_Files {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions actions;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Single_File () throws InterruptedException {

        String projectPath = System.getProperty("user.dir");
        String uploadFilePath = projectPath + "\\uploadFiles\\";

        String cityName = "city.jpg";
        String flowerName = "flower.jpg";
        String templeName = "temple.jpg";

        String cityPath = uploadFilePath + cityName;
        String flowerPath = uploadFilePath + flowerName;
        String templePath = uploadFilePath + templeName;

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        // tìm thẻ input, ko quan trọng ẩn hay hiện -> vẫn có thể upload bằng cách sendkey
        By uploadFile  = By.xpath("input[@type='file']");

        // load file lên
        driver.findElement(uploadFile).sendKeys(cityPath);
        driver.findElement(uploadFile).sendKeys(flowerPath);
        driver.findElement(uploadFile).sendKeys(templePath);

        // verify file đc load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + cityName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + flowerName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + templeName + "']")).isDisplayed());

        // upload từng file

        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start : startButtons) {
            start.click();
            Thread.sleep(2000);
        }

        // verify file đc upload lên
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ cityName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ flowerName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ templeName +"']")).isDisplayed());

    }

    @Test
    public void TC_02_Multiple_Files () throws InterruptedException {

        String projectPath = System.getProperty("user.dir");
        String uploadFilePath = projectPath + "\\uploadFiles\\";

        String cityName = "city.jpg";
        String flowerName = "flower.jpg";
        String templeName = "temple.jpg";

        String cityPath = uploadFilePath + cityName;
        String flowerPath = uploadFilePath + flowerName;
        String templePath = uploadFilePath + templeName;

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        // tìm thẻ input, ko quan trọng ẩn hay hiện -> vẫn có thể upload bằng cách sendkey
        By uploadFile  = By.xpath("input[@type='file']");

        // load file lên
        driver.findElement(uploadFile).sendKeys(cityPath + "\n" + flowerPath + "\n" + templePath);

        // verify file đc load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + cityName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + flowerName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + templeName + "']")).isDisplayed());

        // upload từng file

        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start : startButtons) {
            start.click();
            Thread.sleep(2000);
        }

        // verify file đc upload lên
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ cityName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ flowerName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ templeName +"']")).isDisplayed());

    }

    @Test
    public void TC_03_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

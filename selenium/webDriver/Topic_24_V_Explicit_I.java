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

public class Topic_24_V_Explicit_I {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () {
        driver.get("");

        // chờ cho 1 alert được xuất hiện trong HTML rồi switch qua để accept
        explicitWait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.switchTo().alert().accept();

        // element clickable ( button/ radio/ checkbox/ link/ image)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(""))).click();
        driver.findElement(By.cssSelector("")).click();

        // element visible
        // display ...
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        // element selected  (checkbox và radio)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());

        // element invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // precense
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // element sizre =  số lượng element
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 15));
        Assert.assertEquals(driver.findElements(By.cssSelector("")).size(), 15);

        // attribute
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""), "value", "John"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("value"),  "John");

        //text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), "John"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(), "John");

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

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
        driver.findElement(By.cssSelector("")).

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

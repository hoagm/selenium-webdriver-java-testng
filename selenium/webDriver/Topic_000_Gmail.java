package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_000_Gmail {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        driver.get("https://gmail.com");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () {
        driver.findElement(By.id("identifierId")).sendKeys("hoafgm@gmail.com");
        driver.findElement(By.cssSelector("button.VfPpkd-LgbsSe-OWXEXe-k8QpJ")).click();

    }
    @Test
    public void TC_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        //driver.quit();
    }

}

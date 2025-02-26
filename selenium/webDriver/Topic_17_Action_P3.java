package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_P3 {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Drag_Drop () throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        // trc khi drag and drop
        Assert.assertEquals(targetCircle.getText(), "Drag the small circle here.");

        // drag and drop
        action.dragAndDrop(sourCircle,targetCircle).perform();
        Thread.sleep(3000);

        // Sau khi drag and drop
        Assert.assertEquals(targetCircle.getText(), "You did great!");
        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(), "#03a9f4");

    }
    @Test
    public void TC_02_Drag_Droop_HTML5 () throws InterruptedException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        WebElement sourColumn = driver.findElement(By.cssSelector("div#column-a"));
        WebElement targetColumn = driver.findElement(By.cssSelector("div#column-b"));

        // drag and drop
        action.dragAndDrop(sourColumn,targetColumn).perform();
        Thread.sleep(3000);

        // Sau khi drag and drop
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

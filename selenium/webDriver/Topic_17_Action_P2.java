package webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_17_Action_P2 {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();

        action = new Actions(driver);
    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ClickAndHold_Fix () {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        // click chọn 1 số đầu tiên cần tìm n chưa nhả chuột
        // kéo giữ chuột
        // nhả chuột
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable li"));
        action.clickAndHold(numbers.get(4)) // click và giữ tại element 5
                .pause(Duration.ofSeconds(2))
                .moveToElement(numbers.get(11)) // di chuột đến element 12
                .pause(Duration.ofSeconds(2))
                .release() /// nhả chuột
                .perform();

        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(numberSelected.size(),8);

    }

    @Test
    public void TC_02_ClickAndHol_Random () throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        // click chọn 1 số đầu tiên cần tìm n chưa nhả chuột
        // kéo giữ chuột
        // nhả chuột
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable li"));

        // lấy ra hệ điều hành để dùng phím control( đối vs win) haowjc phím command( đối vs mac)
        String osName = System.getProperty("os.name");
        Keys keys = null;

        if (osName.contains("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        List<String> actualNumbers = new ArrayList<String>();
        actualNumbers.add("2");
        actualNumbers.add("5");
        actualNumbers.add("6");
        actualNumbers.add("9");
        actualNumbers.add("14");
        actualNumbers.add("19");

        // ấn phím ctrl/cmd trên bàn phím
        action.keyDown(keys).perform();

        // cách 1: click từng thằng
//        action.click(numbers.get(2)) // truyền index
//                .click(numbers.get(5))
//                .click(numbers.get(10))
//                .click(numbers.get(6))
//                .click(numbers.get(14))
//                .click(numbers.get(19))
//                .perform();

        // cách 2 chuyển từ String ở actual Number về integer rồi truyền vào để click
        for (String number : actualNumbers) {
            action.click(numbers.get(Integer.parseInt(number) - 1 ));
        }

        action.keyUp(keys).perform();

        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Thread.sleep(3000);
        Assert.assertEquals(numberSelected.size(),6);

        // Expected Number
        List<String> expectedNumbers = new ArrayList<String>();

        for (WebElement number : numberSelected) {
            expectedNumbers.add(number.getText());
        }
        Assert.assertEquals(actualNumbers,expectedNumbers);


    }

    @Test
    public void TC_03_DoubleClick () throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));

        if (driver.toString().contains("Firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",doubleClickButton);
            Thread.sleep(3000);
        }

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_04_RightClick () throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // verify quit menu ko hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        // right click dùng hàm contextClick
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();

        // verify quit menu hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        //hover vào quit menu
        action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();

        // verify quit menu có sự kiện hover
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-hover.context-menu-visible")).isDisplayed());

        // click vào quit menu
        action.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        Thread.sleep(2000);

        // accept alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // verify quit menu ko còn hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        // hover


    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

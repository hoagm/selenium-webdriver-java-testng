package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Custom_Checkbox_Radio {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () throws InterruptedException {
        // dropdown -> default là thẻ select-option. Custom là khác
        // checkbox -> default là thẻ input ko bị ẩn
        // checkbox -> custom là thẻ input bị ẩn hoặc bị thẻ khác đè lên nó
        driver.get("https://login.ubuntu.com/");

        // case 1: thẻ input ko click đc nhưng lại có dùng để verify được

        // case 2: ko dùng thẻ input để click mà dùng thẻ khác để thay thế
        // nhưng thẻ khác đó lại ko verify đc
        // các thẻ như span, label, ul... thì trạng thái

        // case 3: dùng thẻ label để click và input để verify
        // 1 element mà dùng đến 2 locator -> khó maintain -> cũng ko dùng cách này
//        driver.findElement(By.cssSelector("label.new-user")).click();
//        Thread.sleep(2000);
//        By registerRadio = By.cssSelector("input#id_new_user");
//        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        // case 4: dùng thẻ input để click n ko dùng hàm click() của webelement
        // Dùng ha click của JS vaerify bthg

        By registerRadio = By.cssSelector("input#id_new_user");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(registerRadio));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        By termCheckbox = By.cssSelector("input[type='checkbox']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(termCheckbox));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());

    }
    @Test
    public void TC_02_Google_Form () throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(2000);

        By canTho = By.cssSelector("div[data-value='Cần Thơ']");
        driver.findElement(canTho).click();

        // verify = cách hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-value='Cần Thơ'][aria-checked='true']")).isDisplayed());

        // verify lấy ra thuộc tính
        // nên dùng cách này vì cách trên phải define thêm 1 element nữa
        Assert.assertEquals(driver.findElement(canTho).getDomAttribute("aria-checked"),"true");

        By xuQuang = By.cssSelector("div[aria-label='Xứ Quảng']");
        driver.findElement(xuQuang).click();
        Assert.assertEquals(driver.findElement(xuQuang).getDomAttribute("aria-checked"), "true");

        // select all checkboxs
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div[role='checkbox'"));

        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.getDomAttribute("aria-checked").equals("true")) {
                checkbox.click();
            }
        }

        // verify all
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertEquals(checkbox.getDomAttribute("aria-checked"), "true");
        }



    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

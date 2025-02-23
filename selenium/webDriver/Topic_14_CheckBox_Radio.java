package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_14_CheckBox_Radio {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();

        // 1- Browser mowr ra n ko maximize
        // 2- Loading icon chưa biến mất
        // 3- Element tương tác bị che bởi các element khác như banner cookie, menu bar .... -> scroll to
        //

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Checkbox () throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='demo-runner']")));

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        Thread.sleep(2000);

        // step 2
        driver.findElement(dualZoneCheckbox).click();
        Thread.sleep(2000);

        // step 3
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // step 4
        driver.findElement(dualZoneCheckbox).click();
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        // step 5
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By petrol2 = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        // step 6
        driver.findElement(petrol2).click();

        //step 7
        if (!driver.findElement(petrol2).isSelected()) {
            driver.findElement(petrol2).click();
            Assert.assertTrue(driver.findElement(petrol2).isSelected());
        }


    }
    @Test
    public void TC_02_Radio () throws InterruptedException {
        driver.get("https://material.angular.io/components/radio/examples");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='demo-runner']")));
//        Thread.sleep(3000);
        By summerRadioButton = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");

        // step 2
        driver.findElement(summerRadioButton).click();

        // step 3
        if (!driver.findElement(summerRadioButton).isSelected()) {
            driver.findElement(summerRadioButton).click();
            Assert.assertTrue(driver.findElement(summerRadioButton).isSelected());
        }

        // step 4
        driver.get("https://material.angular.io/components/checkbox/examples");
        By checked = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By intermediate = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        // step 5
        driver.findElement(checked).click();
        driver.findElement(intermediate).click();

        // step 6
        Assert.assertTrue(driver.findElement(checked).isSelected());
        Assert.assertTrue(driver.findElement(intermediate).isSelected());

        // step 7
        driver.findElement(checked).click();
        Assert.assertFalse(driver.findElement(checked).isSelected());
        driver.findElement(intermediate).click();
        Assert.assertFalse(driver.findElement(intermediate).isSelected());
    }

    @Test
    public void TC_03_Select_All () {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // 2 select all
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        // 3 deselected all
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        for (WebElement checkbox : allCheckboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }


    }


    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

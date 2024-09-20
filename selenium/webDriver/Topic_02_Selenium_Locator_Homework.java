package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator_Homework {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ID (){
        driver.findElement(By.id("txtFirstname"));
    }
    @Test
    public void TC_02_Class () {
        driver.findElement(By.className("posrelative"));
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("txtEmail"));
    }
    @Test
    public void TC_04_LinkText() {
        driver.findElement(By.linkText("Đăng Ký"));

    }
    @Test
    public void TC_05_Partial_Link_Text() {
        driver.findElement(By.partialLinkText("Đăng"));



    }
    @Test
    public void TC_06_Tagname()  {
        int linkNumber = driver.findElements(By.tagName("a")).size();
        System.out.println("tong so link" + linkNumber);

    }
    @Test
    public void TC_07_Css() {
        driver.findElements(By.cssSelector("input[id='txtSearch']"));
        driver.findElements(By.cssSelector("#txtSearch"));
        driver.findElements(By.cssSelector("input#txtSearch"));


        driver.findElements(By.cssSelector("div[class='posrelative']"));
        driver.findElements(By.cssSelector("div.posrelative"));
        driver.findElements(By.cssSelector(".posrelative"));

        driver.findElements(By.cssSelector("input[name='txtEmail']"));

        driver.findElements(By.cssSelector("a[href='https://alada.vn/tai-khoan/dang-ky.html']"));
        driver.findElements(By.cssSelector("a[href*='tai-khoan']"));
        driver.findElements(By.cssSelector("a[href$='dang-ky.html']"));


        driver.findElements(By.cssSelector("a"));

        driver.findElements(By.cssSelector("input[type='checkbox']"));

    }
    @Test
    public void TC_08_XPath() {
        driver.findElements(By.xpath("//input[@id='txtSearch']"));


        driver.findElements(By.xpath("//div[@class='posrelative']"));

        driver.findElements(By.xpath("//input[@name='txtEmail']"));

        driver.findElements(By.xpath("//a[@href='https://alada.vn/tai-khoan/dang-ky.html']"));
        driver.findElements(By.xpath("//a[contains(@href,'tai-khoan')]"));
        driver.findElements(By.xpath("//a[starts-with(@href,'https://alada.vn/tai-khoan/dang')]"));


        driver.findElements(By.xpath("//a"));

        driver.findElements(By.xpath("//input[@type='checkbox']"));
    }


    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

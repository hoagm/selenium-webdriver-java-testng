package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/login");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () {
        //<input class="email" autofocus="" type="email" data-val="true"
        //<input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email" data-val-regex-pattern="^(([^<>()\[\]\\.,;:\s@&quot;]+(\.[^<>()\[\]\\.,;:\s@&quot;]+)*)|(&quot;.+&quot;))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
        // data-val-required="Please enter your email" id="Email" name="Email">
        // HTML source code
        // Thẻ- thuộc tính- giá trị thuộc tính
        // Tag name- Attribute- Value
        // XPath:   //tagname[@attribute='value']
        // Css:       tagname[attribute='value']

        // để tương tác lên email address-> dùng 8 loại locator
        driver.findElement(By.id(""))
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

package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.get("https://demo.nopcommerce.com/register");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ID () throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);

        driver.findElement(By.id("Email")).sendKeys("Auto");
        Thread.sleep(3000);

        //<input class="email" autofocus="" type="email" data-val="true"
        //<input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email" data-val-regex-pattern="^(([^<>()\[\]\\.,;:\s@&quot;]+(\.[^<>()\[\]\\.,;:\s@&quot;]+)*)|(&quot;.+&quot;))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
        // data-val-required="Please enter your email" id="Email" name="Email">
        // HTML source code
        // Thẻ- thuộc tính- giá trị thuộc tính
        // Tag name- Attribute- Value
        // XPath:   //tagname[@attribute='value']
        // Css:       tagname[attribute='value']

        // để tương tác lên email address-> dùng 8 loại locator

        // sau dâu . gọi hàm/ biến
        //tìm 1 element
//        driver.findElement(By.id(""));

        //Thao tác lên luôn (dùng 1 lần)
        //Nếu ch dùng 1 lần thì ko cần khai báo biến
//        driver.findElement(By.id("")).click();

        // Dùng dữ liệu lưu trữ lại-dùng nhiều lần
        // Dungf nhiều lần thì nên khai báo
        // Dùng WebElement để tìm 1 element
//        WebElement emailTextbox = driver.findElement(By.id());
//        emailTextbox.clear();
//        emailTextbox.sendKeys(...keysTosend: "");
//        emailTextbox.isDisplayed();

        //Tìm nhiều element giống nhau
//        List<WebElement> textboxes = driver.findElement(By.cssSelector(""));
    }
    @Test
    public void TC_02_Class () {
        // Class sẽ ko lấy hết toàn bộ giá trị nếu có khoảng trắng => chỉ lấy 1 class duy nhất
        driver.findElement(By.className("register-next-step-button")).click();

    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));

    }
    @Test
    public void TC_04_LinkText() {
        // chỉ làm việc vs element và link có text
        // thẻ a có thuộc tính href
        driver.findElement(By.linkText("Sitemap"));

    }
    @Test
    public void TC_05_Partial_Link_Text() {
        // có thể lấy hết toàn bộ text hoặc 1 phần - phần gốc là downloads (hay dùng)
        // text ở trên UI- ko phải text dưới html
        // vd: trên UI là "DIGITAL", html là "Digital" => giá trị tìm phải là "DIGITAL"
        driver.findElement(By.partialLinkText("Digital"));
        driver.findElement(By.partialLinkText("download"));



    }
    @Test
    public void TC_06_Tagname()  {
        // Khi mình muốn tìm tất cả các element giống nhau (thẻ của component giống nhau)
        // Tất cả các textbox / button
        driver.findElements(By.tagName("button"));

        driver.findElements(By.tagName("input"));


    }
    @Test
    public void TC_07_Css() {
        // css có thể cover đc cả 6 loại ở trên
        // cover id
        // html: tagname-attribute-value
        // css: tagname[attribute='value']

        driver.findElement(By.cssSelector("input[id='small-searchterms']"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("input#small-searchterms"));

        //class
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']")); // = phải lấy hết toàn bộ
        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector(".register-next-step-button"));

        // name => name ko có kiểu viết tắt, phải viết toàn bộ
        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));

        // linktext:  lấy hết toàn bộ
        driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2Fregister']"));
        // partial link: href* là lấy 1 phần bất kỳ dùng *
        driver.findElement(By.cssSelector("a[href*='login?']"));
        // lấy ở cuối dùng $
        driver.findElement(By.cssSelector("a[href$='Fregister']"));



        //
        driver.findElement(By.cssSelector("a"));



    }
    @Test
    public void TC_08_XPath() {
        // XPath: //tagname[@attribute='value']
        // lấy thuộc tính dùng @
        // lấy hàm thì bỏ @ dùng () - ví dụ text

        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class,'register-next-step-button')]"));


        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        driver.findElement(By.xpath("//a[@text()='Register']"));
        driver.findElement(By.xpath("//a[@contains(text(),'Shipping')]"));
        driver.findElement(By.xpath("//a[@contains(text(),'& returns')]"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));

    }

    @Test
    public void TC_09_Relative_Locator() {
        // element/ By A

        // element/ By B

        // element/ By C

        // element/ By D

        // element/ By E


    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

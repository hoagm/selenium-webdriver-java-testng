package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Iframe {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Select select;


    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Google_Map () {
        // A chứa iframe B
        driver.get("https://embedgooglemap.net/");


//        driver.switchTo().frame(0); // switch vào iframe dùng index sẽ bắt đầu từ 0 -> id dễ bị thay đổi -> ko nên dùng
//        driver.switchTo().frame(""); // dùng name hoặc id, n có cái có id/name, có cái ko => ko nên dùng
//        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv button iframe"))); // nên dùng element vì nó linh động

        // switch vào iframe B
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.gmap_canvas>iframe"))); // nên dùng element vì nó linh động

        // đang ở B lấy ra element trong B
        String address = driver.findElement(By.cssSelector("div.address")).getText();
        System.out.println(address);

        // B chứa  iframe C
        // switch vào iframe C
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv>div>div>iframe"))); // iframe số 2

        // đang ở C
        System.out.println(driver.getPageSource());

        // switch về B
        driver.switchTo().parentFrame();

        // B quay lai A
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("div.light input")).clear();
        driver.findElement(By.cssSelector("div.light input")).sendKeys("vietnam");




    }
    @Test
    public void TC_02_Formsite () throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer iframe")));

        // select dropdown year
        new Select(driver.findElement(By.cssSelector("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Senior");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Senior");

        // select dropdown residence
        new Select(driver.findElement(By.cssSelector("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("South Dorm");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"South Dorm");

        // select button Gender
        WebElement gender = driver.findElement(By.cssSelector("td.highlight label"));
        gender.click();
        Thread.sleep(3000);
        Assert.assertEquals(gender.getText(), "Male");

        // click submit
        driver.findElement(By.cssSelector("input#FSsubmit")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.invalid_message")).getText(),"Please review the form and correct the highlighted items.");

        // click login
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("nav[class='header header--desktop'] a.menu-item-login")).click();
        driver.findElement(By.cssSelector("button#login")).click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}

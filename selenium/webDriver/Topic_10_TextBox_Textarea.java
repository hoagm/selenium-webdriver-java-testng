package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_TextBox_Textarea {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://live.techpanda.org/");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Textbox () {
        driver.findElement(By.cssSelector("div.footer [title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        String firstName = "Donal";
        String lastName = "Trump";
        String email = "donaltrump" + new Random().nextInt(999) + "@gmail.net";
        String password = "1234567";

        // nếu chuyền vào ngoặc "" ("firstName") thì sẽ được hiểu là 1 chuỗi chứ ko phải là 1 biến
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();




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

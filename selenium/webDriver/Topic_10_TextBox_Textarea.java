package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Textbox () {
        driver.get("http://live.techpanda.org/");

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
    public void TC_02_OrangeHRM () throws InterruptedException {
        // step1
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String firstName = "Donal";
        String lastName = "Trump";
        String password = "a1234567";
        String number = "4123-" + new Random().nextInt(9999) + "-2850";
        String userName = "donal" + new Random().nextInt(9999);
        String passportNumber = "2433-4558-3294-1123";
        String passportComment = "this data test\nautomation Fc";

        // step2
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        // step3
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Thread.sleep(4000);

        // step 4
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(4000);

        //step 5
        driver.findElement(By.cssSelector("input.orangehrm-firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input.orangehrm-lastname")).sendKeys(lastName);
        Thread.sleep(4000);

        String empID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");

        driver.findElement(By.cssSelector("span.oxd-switch-input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        // step 6
        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Thread.sleep(4000);

        // step 7
        Assert.assertEquals(driver.findElement(By.cssSelector("input[class='oxd-input oxd-input--active orangehrm-firstname']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[class='oxd-input oxd-input--active orangehrm-lastname']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),empID);

        // step 8
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);

        // step 9
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();

        // step 10
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys(passportComment);
        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Thread.sleep(3000);

        // step 11
        driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();
        Thread.sleep(2000);

        // step 12
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passportNumber);
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).getAttribute("value"),passportComment);

        // step 14
        driver.findElement(By.cssSelector(".oxd-userdropdown")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);


        // step 15
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        System.out.println(userName);
        System.out.println(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();


        // step 16
        driver.findElement(By.xpath("//span[text()='My Info']/parent::a/parent::li")).click();
        Thread.sleep(3000);
        
        // step 17
        Assert.assertEquals(driver.findElement(By.cssSelector("input.orangehrm-firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input.orangehrm-lastname")).getAttribute("value"),lastName);
        System.out.println("firstName" + firstName);
        System.out.println("lastName" + lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),passportNumber);
        Thread.sleep(3000);

        // step 18
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        driver.findElement(By.cssSelector("i[class='oxd-icon bi-pencil-fill']")).click();

        // step 19
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passportNumber);
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).getAttribute("value"),passportComment);

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

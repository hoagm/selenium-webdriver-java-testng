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

public class Topic_08_Element_Excercise {

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
    public void TC_01_Displayed () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("auto");
            System.out.println("Email textbox is Display");
        } else {
            System.out.println("Email textbox is not Display");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("edu");
            System.out.println("Education is display");
        }else {
            System.out.println("Education is not display");
        }

        if (driver.findElement(By.cssSelector("#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("#under_18")).click();
            System.out.println("Age under 18 is display");
        }else {
            System.out.println("Age under 18 is not display");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name user text 5 is display");
        }else {
            System.out.println("Name user text 5 is not display");
        }

    }
    @Test
    public void TC_03_Selected () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("auto");
            System.out.println("Email textbox is Display");
        } else {
            System.out.println("Email textbox is not Display");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("edu");
            System.out.println("Education is display");
        }else {
            System.out.println("Education is not display");
        }

        if (driver.findElement(By.cssSelector("#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("#under_18")).click();
            System.out.println("Age under 18 is display");
        }else {
            System.out.println("Age under 18 is not display");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name user text 5 is display");
        }else {
            System.out.println("Name user text 5 is not display");
        }


    }

    @Test
    public void TC_02_Enable () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("auto");
            System.out.println("Email textbox is isEnabled");
        } else {
            System.out.println("Email textbox is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("edu");
            System.out.println("Education is isEnabled");
        }else {
            System.out.println("Education is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("#under_18")).isEnabled()) {
            driver.findElement(By.cssSelector("#under_18")).click();
            System.out.println("Age under 18 is isEnabled");
        }else {
            System.out.println("Age under 18 is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            driver.findElement(By.cssSelector("select#job1")).click();
            System.out.println("Job role 1 is isEnabled");
        }else {
            System.out.println("Job role 1 is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Interests Checkbox is isEnabled");
        }else {
            System.out.println("Interests Checkbox is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("input#slider-1")).isEnabled()) {
            System.out.println("Job role 1 is isEnabled");
        }else {
            System.out.println("Job role 1 is not isEnabled");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isEnabled()) {
            System.out.println("Name user text 5 is isEnabled");
        }else {
            System.out.println("Name user text 5 is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("#slider-1")).isEnabled()) {
            System.out.println("Slider 1 is isEnabled");
        }else {
            System.out.println("Slider 1 is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("#disable_password")).isEnabled()) {
            System.out.println("Password is isEnabled");
        }else {
            System.out.println("Password is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("#radio-disabled")).isEnabled()) {
            System.out.println("Radio button is isEnabled");
        }else {
            System.out.println("Radio button is not isEnabled");
        }

        if (driver.findElement(By.cssSelector("select#job3")).isEnabled()) {
            System.out.println("Select job is display");
        }else {
            System.out.println("Select job is not display");
        }

        if (driver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled()) {
            System.out.println("Biograph is display");
        }else {
            System.out.println("Biograph is not display");
        }

        if (driver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled()) {
            System.out.println("Interested check is display");
        }else {
            System.out.println("Interested check not display");
        }



    }

    @Test
    public void TC_04_MailChimp_validate () throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
//        Thread.sleep(3000);

//        driver.findElement(By.cssSelector("#onetrust-close-btn-container")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("autotest@gmail.net");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Thread.sleep(3000);

        // empty
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check not-completed']")).isDisplayed());
//
//        // lowercase
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("sele");
//        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());

        // uppercase
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("SELE");
////        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());
//
////        Specialcase
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("!!@#");
////        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());
//
//
//        // Number case
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("1234567");
////        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());

//        // contain username
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("auto");
//        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check not-completed']")).isDisplayed());
//
//        // 8 character
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("automation");
//        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());
//        Thread.sleep(3000);
//
//        // Full
//        driver.findElement(By.cssSelector("input#new_password")).clear();
//        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Abc!1234");
//        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
//        Thread.sleep(3000);
//
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='uppercase-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='special-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());

    }


    @Test
    public void TC_05_Page_Title () {
        driver.get("https://automationfc.github.io/basic-form/index.html");



    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}

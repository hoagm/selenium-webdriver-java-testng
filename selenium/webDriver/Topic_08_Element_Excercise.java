package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Element_Excercise {

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
    public void TC_01_Displayed () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("auto");
            System.out.println("Email textbox is Display");
        } else {
            System.out.println("Email textbox is not Display");
        }

        if (driver.findElement(By.cssSelector("input#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#edu")).sendKeys("edu");
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

        if (driver.findElement(By.cssSelector("input#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#edu")).sendKeys("edu");
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

        if (driver.findElement(By.cssSelector("input#edu")).isEnabled()) {
            driver.findElement(By.cssSelector("input#edu")).sendKeys("edu");
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

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name user text 5 is display");
        }else {
            System.out.println("Name user text 5 is not display");
        }



    }

    @Test
    public void TC_04_Page_Source () {
        driver.get("https://automationfc.github.io/basic-form/index.html");


    }


    @Test
    public void TC_05_Page_Title () {
        driver.get("https://automationfc.github.io/basic-form/index.html");



    }
    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

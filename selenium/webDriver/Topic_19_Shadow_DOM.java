package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Shadow_DOM {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions actions;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Github () {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // tim ra element chứa shadow đầu tiên
        WebElement firstShadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));

        // lấy ra cái shadow đầu tiên
        SearchContext firstShadowRoot = firstShadowHostElement.getShadowRoot();

        // element nằm trong shadow
        // shadow chỉ dùng đc với css, ko dùng đc vs xpath
        // do chỉ lấy từ shadow root trở xuống nên ko đi từ <div id="shadow_host"> để tìm a, mà tìm a luôn
        // ko lấy từ locator qu
        String shadowText = firstShadowRoot.findElement(By.cssSelector("a")).getText();

        firstShadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("selenium");
        System.out.println(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")));

        // tìm ra element chứa cái shadow thứ 2
        WebElement secondShadowHostElement = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));

        // lấy caais shadow thứ 2 nằm trong shadow 1
        SearchContext secondShadowRoot = secondShadowHostElement.getShadowRoot();

        // lấy text ra
        System.out.println(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_host>div")).getText());

    }
    @Test
    public void TC_02_Book () throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);

        WebElement firstShadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext firstShadowRoot = firstShadow.getShadowRoot();

//        WebElement secondShadow = firstShadowRoot.findElement(By.cssSelector("book-input-decorator"));
//        SearchContext secondShadowRoot = secondShadow.getShadowRoot();

        firstShadowRoot.findElement(By.cssSelector("input#input")).sendKeys("Hary porter");
        Thread.sleep(3000);

        firstShadowRoot.findElement(By.cssSelector("div.icon")).click();

        // kết quả sau khi search
        WebElement thirdShadow = firstShadowRoot.findElement(By.cssSelector("book-explore[class='_page']"));
        SearchContext thirdShadowRoot = thirdShadow.getShadowRoot();

        WebElement fourShadow = thirdShadowRoot.findElement(By.cssSelector("book-item"));
        SearchContext fourShadowRoot = fourShadow.getShadowRoot();

        fourShadowRoot.findElement(By.cssSelector("div.title-container h2"));





//        WebElement firstShadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
//        SearchContext firstShadowRoot = firstShadow.getShadowRoot();
//
//        WebElement secondShadow = firstShadow.findElement(By.cssSelector("app-header[effects='waterfall']"));
//        SearchContext secondShadowRoot = secondShadow.getShadowRoot();
//
//        WebElement thirdShadow = secondShadowRoot.findElement(By.cssSelector("div.toolbar-bottom"));
//        SearchContext thirdShadowRoot = thirdShadow.getShadowRoot();
//
//        WebElement fourShadow = thirdShadowRoot.findElement(By.cssSelector("book-input-decorator"));
//        SearchContext fourShadowRoot = fourShadow.getShadowRoot();
//
//        fourShadowRoot.findElement(By.cssSelector("input")).sendKeys("Hary porter");







    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

package webDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Window_Tab {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    Actions action;
    Alert alert;
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Github () throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // lấy ra window ID của 1 cửa sổ đang active (driver đang đứng đó)
        String githubID = driver.getWindowHandle();
        System.out.println("windowID" + driver.getWindowHandle());

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        // hiện tại đang có 2 tab
        switchToWindowByID(githubID);
        Set<String> allWindows;

        // đã qua trang google
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("textarea[title='Tìm kiếm']")).sendKeys("selenium");

        // quay lại trang github
        String googleID = driver.getWindowHandle();
        switchToWindowByID(googleID);

//        allWindows = driver.getWindowHandles();// đã khởi tạo ở trên nên chỉ cần gán lại thôi
//
//        for (String window : allWindows) {
//            if (!window.equals(googleID)) {
//                driver.switchTo().window(window);
//                break;
//            }
//        }
        // đã quay lại trang github
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // quay lại github rồi, click tiếp vào fb
        driver.findElement(By.cssSelector("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);

        // switch qua FB
        switchToWindowByTitle("Facebook – log in or sign up");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // kiểm tra title
        System.out.println(driver.getTitle());

        // Switch về gihub
        switchToWindowByTitle("Selenium WebDriver");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        switchToWindowByTitle(githubID);

    }

    // cách 1 : chỉ dùng được khi có 2 tab/window, nếu sang tab thứ 3 thì ko dùng đc
    private void switchToWindowByID(String windowID) {
        // lấy ra window ID của 2 tab/window
        // List cho phép lưu trùng lặp các giá trị giống nhau
        // Set ko lưu giá trị bị trùng lặp
        Set<String> allWindows = driver.getWindowHandles();

        // dùng vòng lặp để lấy ra từng ID
        for (String window : allWindows) {

            // nếu ID nào khác vs ID truyền vào thì switch qua
            if (!window.equals(windowID)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // cách 2: dùng cho từ 2 window trở lên -> nên dùng cách này
    private void switchToWindowByTitle(String expectedTitle) {
        // lấy ra window ID của 2 tab/window
        // List cho phép lưu trùng lặp các giá trị giống nhau
        // Set ko lưu giá trị bị trùng lặp
        Set<String> allWindows = driver.getWindowHandles();

        // dùng vòng lặp để lấy ra từng ID
        for (String window : allWindows) {

            // cho switch trước vào từng window
            driver.switchTo().window(window);

            // lấy ra page title của page hiện tại
            String pageTittle = driver.getTitle();

            // kiểm tra nếu có tittle = cái mình cần thì break để ở lại window đó
            if (pageTittle.equals(expectedTitle)){
                break;
            }
        }
    }

    // nếu title dài quấ thì có thể dùng contains, chứa 1 phần title
    private void switchToWindowByContainTitle(String expectedTitle) {
        // lấy ra window ID của 2 tab/window
        // List cho phép lưu trùng lặp các giá trị giống nhau
        // Set ko lưu giá trị bị trùng lặp
        Set<String> allWindows = driver.getWindowHandles();

        // dùng vòng lặp để lấy ra từng ID
        for (String window : allWindows) {

            // cho switch trước vào từng window
            driver.switchTo().window(window);

            // lấy ra page title của page hiện tại
            String pageTittle = driver.getTitle();

            // kiểm tra nếu có tittle = cái mình cần thì break để ở lại window đó
            if (pageTittle.contains(expectedTitle)){
                break;
            }
        }
    }

    // close tất cả các tab/window ngoại trừ trang gốc
    private void closeAllExceptMain(String windowID) {
        // lấy ra window ID của 2 tab/window
        // List cho phép lưu trùng lặp các giá trị giống nhau
        // Set ko lưu giá trị bị trùng lặp
        Set<String> allWindows = driver.getWindowHandles();

        // dùng vòng lặp để lấy ra từng ID
        for (String window : allWindows) {

            // nếu ID nào khác vs ID truyền vào thì switch qua
            if (!window.equals(windowID)) {
                driver.switchTo().window(window);

                // close
                driver.close();
            }
        }

        // sau khi close hết thì cần phải switch driver về trang main
        driver.switchTo().window(windowID);
    }

    @Test
    public void TC_02_techPanda () throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        Thread.sleep(3000);

        // click tab mobile
        driver.findElement(By.cssSelector("//a[text()='Mobile']")).click();
        Thread.sleep(3000);

        String techPandaId = driver.getWindowHandle();

        // click add to compare
        driver.findElement(By.cssSelector("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//li")).getText(), "The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.cssSelector("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//li")).getText(), "The product IPhone has been added to comparison list.");

        // click compare button
        driver.findElement(By.cssSelector("button[title='Compare']")).click();

        // switch to compare page
        switchToWindowByContainTitle("Products Comparison List");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title h1")).getText(), "COMPARE PRODUCTS");

        // cách 1: close compare page - đã bao gồm switch về trang main
        closeAllExceptMain(techPandaId);

        // cách 2: click cloose button và switch về
        driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        switchToWindowByTitle("Mobile");


        // click to clear all
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        // switch vào alert khi nó hiện lên và accept nó
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        alert.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//li")).getText(), "The comparison list was cleared.");

    }

    @Test
    public void TC_03_dictionary () throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        Thread.sleep(3000);
        String dictionaryId = driver.getWindowHandle();

        // click vào đăng nhập
        driver.findElement(By.xpath("//div[@class='hdn hdib-s'] //span[text()='Đăng nhập']")).click();
        Thread.sleep(3000);

        // switch to new window
        switchToWindowByTitle("Login");

        // click login
        driver.findElement(By.xpath("form#gigya-login-form input.gigya-input-submit")).click();
        Thread.sleep(3000);

        // verify message
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Email *']/following-sibling::span")).getText(), "This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Password *']/following-sibling::span")).getText(), "This field is required");

        // close window login, switch to dictionary
        closeAllExceptMain(dictionaryId);

        // nhập vào ô tìm kiếm
        String combination = "combination";
        driver.findElement(By.cssSelector("input[aria-label='Tìm kiếm']")).sendKeys(combination);
        driver.findElement(By.cssSelector("div[class='lmax lch1'] button[type='submit']")).click();

        // verify search
        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-id='cald4'] span span")).getText(), combination);

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

//        driver.quit();
    }

}

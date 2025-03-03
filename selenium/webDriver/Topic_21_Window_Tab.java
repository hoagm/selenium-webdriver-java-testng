package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Window_Tab {

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

        driver.findElement(By.cssSelector("textarea[title='Search']")).sendKeys("selenium");

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
    }

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

    @Test
    public void TC_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

}

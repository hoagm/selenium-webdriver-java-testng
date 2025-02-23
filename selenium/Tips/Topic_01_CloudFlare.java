package Tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_CloudFlare {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;


    @BeforeClass
    public void initialBrowser() {


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Giang My Hoa\\AppData\\Local\\Google\\Chrome\\User Data");
        chromeOptions.addArguments("--profile-directory=Profile 3");
        driver = new ChromeDriver(chromeOptions);


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:\\Users\\Giang My Hoa\\AppData\\Local\\Microsoft\\Edge\\User Data\\");
        edgeOptions.addArguments("--profile-directory=Profile 2");
        driver = new EdgeDriver(edgeOptions);


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
    }


    // 2- Action/ Execute
    @Test
    public void TC_01_ () {
        driver.get("https://www.fahasa.com/");

    }
    @Test
    public void TC_02_ () {


    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}

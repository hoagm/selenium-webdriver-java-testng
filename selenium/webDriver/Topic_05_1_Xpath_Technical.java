package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_1_Xpath_Technical {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () {

        // text()=
        // text nằm trên cùng hàng với node(tagname) => tuyệt đối( ko có khoảng trắng/xuống dòng/tab ở đầu/cuối)
        driver.findElement(By.xpath("//h3[text()='TRẢI NGHIỆM CÙNG ALADA']"));


        // contains(text(),'')
        // lấy 1 phần của text ở bất kỳ đoạn nào trong câu
        // có khoảng trắng/tab/ vẫn work đc tương đối
        // nhưng text phải nằm ở index đầu tiên, ko nằm trong child node
        driver.findElement(By.xpath("//p[contains(text(),'khuyến khích')]"));

        // contains(string(),'')
        // text nằm trên chính node đó/nằm trong child node bất kỳ
        // có khoảng trắng/tab/ vẫn work đc
        driver.findElement(By.xpath("//p[contains(string(),'Alada với hệ thống hỗ trợ học tập chuyên nghiệp, các chức năng đa dạng như: thảo luận, bài tập, bài kiểm tra sẽ giúp học viên hệ thống kiến thức, học tập hiệu quả hơn.')]"));

        // concat(): text vừa chứa ký tự nháy đơn, vừa chứa ký tự nháy đôi Hello "John", what's happened?
        // nháy đơn bọc nháy đôi và nháy đôi bọc nháy đơn
//        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));

        // AND vs OR giống trong lập trình
        driver.findElement(By.xpath("//input[@class='text form-control' and @id ='txtFirstname']"));
        driver.findElement(By.xpath("//input[@class='text form-control' or @id ='txtFirstname']"));

        // not
        // lấy tất cả input ko có id @txtFirstname nằm trong div có class = field
        driver.findElement(By.xpath("//div[@class='field']//input[not(@id='txtFirstname')]"));

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

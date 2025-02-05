package webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_06_Element_Commands {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        // tuowng tác vs Browser thông qua driver
        driver = new FirefoxDriver();

        System.out.println("Driver ID = " + driver.toString());

//        driver.get("https://www.facebook.com/");


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_Element() {
        // tương tác trực tiếp lên
        driver.findElement(By.cssSelector(""));

        // thao tac nhiều lần lên element -> khai báo biến
        WebElement element = driver.findElement(By.cssSelector(""));

        // xóa dât trong 1 editable element: dropdown, textbox, ...
        element.clear();

        // nhập data vào editable element
        element.sendKeys("automation");


        // cho phép element tìm tiếp element
        // ví dụ thằng cha dùng 1 locator( css )  thằng con dùng 1 loại locator xpath
        driver.findElement(By.cssSelector("div.form-field")).
                findElement(By.xpath("//input[@id='First Name]"));
        // cả cha và con phải dùng chung 1 locator (css)
        driver.findElement(By.cssSelector("div.form-field input#First Name"));

        // tìm 1 element vs locator là tham số truyền vào
        driver.findElement(By.cssSelector(""));
        // tìm nhiều element vs locator là tham số truyền vào
        driver.findElements(By.cssSelector(""));

        // click lên 1 element: button, checkbox, radio, link. img, dropdown ...
        element.click();

        // tương đg vs việc submit thông tin lên serve
        // giả lập hành vi enter của end-user
        // chú ý chỉ dùng đc vs thẻ form và bên trong thẻ form (form submit)
        element.submit();


        // verify thông in/ dữ liệu đã action

        // kiểm tra 1 data có hiển thị hay ko- áp dụng cho tất cả các element
        element.isDisplayed();

        // kiểm tra xem 1 element đã đc chọn hay chưa: dropdown, checkbox, radio.
        // nếu dùng cho cái khác (text box ,..) luôn trả về false
        element.isSelected();

        // kiểm tra 1 element có cho phép thao tác lên hay ko
        // cho phép sửa data
        // trả về true: đc phép chỉnh sửa, thao tác
        // dùng để test tính năng phân quyền
        element.isEnabled();

        // lấy data
        // Lấy ra width-height của element
        element.getSize();

        // lấy ra text của element
        element.getText();

        // lấy attribute
        element.getAttribute("placeholder");

        // nếu element nằm trong shadow DOM ( na ná iframe )
        element.getShadowRoot();

        //
        element.getAriaRole();
        element.getDomAttribute("");
        element.getDomProperty("");
        element.getAccessibleName();

        // verify font, font size, background ... ( miễn là liên quan đến css)
        element.getCssValue("background-color");

        // lấy ra vị trí của element (góc trên bên trái) so vs lại browser
        element.getLocation();

        // lấy ra chiều rộng chiều cao
        element.getSize();

        // tổng hợp của location và size
        Rectangle elementRect = element.getRect();
        elementRect.getDimension(); // = get size
        elementRect.getPoint();// = get location

        // lấy tên thẻ của element
        element.getTagName();

        // take screenshot lỗi
        element.getScreenshotAs(OutputType.BYTES); // its dùng
        element.getScreenshotAs(OutputType.FILE); // lưu dưới dạng file trong ổ cứng
        element.getScreenshotAs(OutputType.BASE64); // ưu điểm nhẹ, rất nhej

        element.


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

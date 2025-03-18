package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_22_JavaScriptExecutor {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String emailAddress;


    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        // ép kiểu
        jsExecutor = (JavascriptExecutor) driver;

        emailAddress = "donaltrump" + new Random().nextInt(9999) + "@gmail.net";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    // 2- Action/ Execute
    @Test
    public void TC_01_ () throws InterruptedException {
        driver.get ("http://live.techpanda.org/index.php/");
        //Click element bi an or che
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']")));
        Thread.sleep(5000);

        // Click vào 1 element mà không cần Hover chuột vào Menu/ Tooltip
        driver.get("https://www.fahasa.com/");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Sách Trong Nước']")));
        Thread.sleep(5000);

    }
    @Test
    public void TC_02_TechPanda () {
        // truy câp URl
        navigateToUrlByJS("https://live.techpanda.org/");

        // Get domain
        String techPandaDomain = (String) executeForBrowser("return document.domain");
        System.out.println(techPandaDomain);
        Assert.assertEquals(techPandaDomain, "live.techpanda.org");

        // Get URL
        String techPandaURL = (String) executeForBrowser("return document.URL");
        System.out.println(techPandaURL);
        Assert.assertEquals(techPandaURL, "https://live.techpanda.org/");

        // click mobile, dùng hàm highlight để nhìn rõ hơn
        hightlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");

        // add to cart
        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div/button");

        // verify message
        hightlightElement("//li[@class='success-msg'] //span");
        Assert.assertEquals(getElementTextByJS("//li[@class='success-msg'] //span"), "Samsung Galaxy was added to your shopping cart.");

        // open customer service page verify title
        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String customerServiceTitle = (String) executeForBrowser("return document.title");
        System.out.println(techPandaDomain);
        Assert.assertEquals(techPandaDomain, "Customer Service");

        // scroll to element
        scrollToElementOnTop("//input[@id='newsletter']");

        // send key
        hightlightElement("//input[@id='newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']", emailAddress);

        // click subscribe
        hightlightElement("//span[text()='Subscribe']/ancestor::button");
        clickToElementByJS("//span[text()='Subscribe']/ancestor::button");

        // còn 1 bước verify, về làm bổ sung


        // Get domain facebook
        navigateToUrlByJS("https://www.facebook.com/");
        String facebookDomain = (String) executeForBrowser("return document.domain");
        System.out.println(techPandaDomain);
        Assert.assertEquals(techPandaDomain, "www.facebook.com");

    }

    @Test
    public void TC_03_HTML5 () {
        // truy câp URl
        navigateToUrlByJS("https://warranty.rode.com/register ");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        driver.findElement(By.xpath("//button[contains(text(),'Register']")).click();

        String validationMessage;

        // cách 1 validate bằng js, thường sđụng trong selenium 3.x
        validationMessage = getElementValidationMessage("//input[@id='name']");

        // cách 2: selenium version 4. -> validate bằng dom properties
        WebElement element = driver.findElement(By.xpath("//input[@id='name']"));
        validationMessage = element.getDomProperty("validationMessage");

        sleepInSecond(3);
        Assert.assertEquals(validationMessage, "Please fill out this field.");

        // send key name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("automation");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);
        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill out this field.");

        // send email sai
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmai@hotmail.com");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);
        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "A part following '@' should not contain the symbol '@'.");

    }

    @Test
    public void TC_04_TechPanda5 () {
        Random rand = new Random();

        navigateToUrlByJS("https://live.techpanda.org/");

        // click vào my account
        clickToElementByJS("//div[@id='header-account']//a[text()='My Account']");
        sleepInSecond(2);

        // click create acc
        clickToElementByJS("//a[@title='Create an Account']");
        sleepInSecond(2);

        // nhập data
        sendkeyToElementByJS("//input[@id='firstname']", "auto");
        sendkeyToElementByJS("//input[@id='middlename']", "FC");
        sendkeyToElementByJS("//input[@id='lastname']", "mation");

        String email = "donaltrump" + rand.nextInt(999) + "@gmail.net";
        sendkeyToElementByJS("//input[@id='email_address']", email);

        sendkeyToElementByJS("//input[@id='password']", "a@123456");
        sendkeyToElementByJS("//input[@id='confirmation']", "a@123456");

        // submit
        clickToElementByJS("//button[@title='Register']");

        // verify message
        

    }

    // 3- Clean
    @AfterClass
    public void cleanBrowser() {

        driver.quit();
    }

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        // tương đương với
//        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(locator)));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

}

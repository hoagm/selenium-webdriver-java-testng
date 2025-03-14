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

public class Topic_22_JavaScriptExecutor {

    // 1- Setup: OS/ Web/ Browser/ Data/ Page...
    WebDriver driver;
    JavascriptExecutor jsExecutor;


    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

        // ép kiểu
        jsExecutor = (JavascriptExecutor) driver;

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

        // click mobile
        clickToElementByJS("//a[text()='Mobile']");

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
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(locator)));
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

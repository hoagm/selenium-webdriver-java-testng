package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic_01_DataType {

    // 2 nhóm kiểu dữ liệu

    // cách khai báo:
    // Access Modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1. Access Modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (ngoài/trong hàm)
    public char cName ='b';

    // 2.1 Access Modifier - Kiểu dữ liệu - Tên biến
    public char cAddress;

    // 2.2 Tên biến - Giá trị gán sau (trong hàm)
    public void clickToElement() {
        cAddress = 'c';
    }

    // Nhóm 1 : kiểu data nguyên thủy
    // char: ký tự (character - define đúng 1 ký tự duy nhất) - khi gán gtri thì nằm trong dấu nháy đơn
    char cNumber = 'a';

    // byte/ short/ int/ long: số nguyên - khi gán gtri ko nằm trong dấu gì
    byte bNumber = -120;
    short sNumber = 1200;
    int iNumber = 350000;
    long lNumber = 234240234;

    // float/ double: số thực - khi gán gtri ko nằm trong dấu gì
    float fNumber = 15.7f;
    double dNumber = 15.925d;

    // boolean: logic - khi gán gtri ko nằm trong dấu gì
    boolean gender = false;

    // Nhóm 2: Kiểu tham chiếu dữ liệu
    // String: chuỗi - khi gán gtri thì nằm trong dấu nháy đôi
    String myName = "Hòa";

    // Class: để dùng phải gọi nó bằng cách new
    FirefoxDriver fDriver = new FirefoxDriver();
    Topic_01_DataType topic01 = new Topic_01_DataType();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Array: các giá trị trong mảng phải có cùng kiểu dữ liệu - mảng là cố định, bắt buộc phải define trước
    String [] studentName = {"Hiền", "An"};
    Integer[] phone = { 12123, 243243, 5654};


    // List/ Set/ Queue- mảng động, trong quá trình chạy có thể tự CRUD
    List<String> studentAdd = new ArrayList<String>();

    // Map
    Map<String, Integer> zip = new HashMap<String, Integer>();

    // Object: có thể ép kiểu sang những dạng khác
    Object name = "Na";
    Object oPhone = 123;
    Object isDisplayed = true;
}

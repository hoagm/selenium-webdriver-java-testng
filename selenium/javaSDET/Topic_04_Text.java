package javaSDET;

import org.testng.Assert;

public class Topic_04_Text {
    public static void main(String[] args) {
        String  fullName = "Auto";
        System.out.println(fullName);

        fullName = "Tesst";
        System.out.println(fullName);

        String textItem = "\n" +
                "                Second Option\n" +
                "            ";
        Assert.assertEquals(textItem.trim(), "Second Option");

        // topic 16 alert
        String authenLink = "https://the-internet.herokuapp.com/basic_auth";

        String username = "admin";
        String password = "admin";

        // tách chuỗi dựa vào ký tự

        String[] text = authenLink.split("//");
        System.out.println(text[0]);
        System.out.println(text[1]);

        authenLink = text[0] + "//" + username + ":" + password  + "@" + text[1];
        System.out.println(authenLink);

    }
}

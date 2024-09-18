package javaSDET;

public class Topic_02_Primitive_Reference {
    public static void main(String[] args) {
        int x = 42;
        int y = x;
        System.out.println("x =" + x);
        System.out.println("y =" + y);

        x = 50;
        System.out.println("x =" + x);
        System.out.println("y =" + y);
    }
}

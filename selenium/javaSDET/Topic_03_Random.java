package javaSDET;

import java.util.Random;

public class Topic_03_Random {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextLong());
        System.out.println(rand.nextInt(99));

        System.out.println("donaltrump" + rand.nextBoolean() + "@gmail.net");
        System.out.println("donaltrump" + rand.nextDouble() + "@gmail.net");
        System.out.println("donaltrump" + rand.nextFloat() + "@gmail.net");
        System.out.println("donaltrump" + rand.nextInt() + "@gmail.net");
        System.out.println("donaltrump" + rand.nextInt(999) + "@gmail.net");
        System.out.println("donaltrump" + rand.nextInt() + "@gmail.net");
    }
}


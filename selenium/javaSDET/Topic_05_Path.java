package javaSDET;

public class Topic_05_Path {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String projectPath = System.getProperty("user.dir");
        String cityName = "city.jpg";
        String flowerName = "flower.jpg";
        String templeName = "temple.jpg";


        System.out.println(osName);
        System.out.println(javaVersion);
        System.out.println(projectPath + cityName);
        System.out.println(projectPath + flowerName);
        System.out.println(projectPath + templeName);
    }
}

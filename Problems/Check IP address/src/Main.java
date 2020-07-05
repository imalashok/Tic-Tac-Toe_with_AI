import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String potentialIP = scanner.nextLine();

        String regexp = "(((0|\\d{0,2})|(1\\d{0,3})|(2[0-5]{0,2}))\\.){3}((0|\\d{0,2})|(1\\d{0,3})|(2[0-5]{0,2}))";

        System.out.println(potentialIP.matches(regexp) ? "YES" : "NO");
    }
}
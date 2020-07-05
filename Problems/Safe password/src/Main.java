import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String potentialPass = scanner.nextLine();

        String regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{12,}$";

        System.out.println(potentialPass.matches(regexp) ? "YES" : "NO");
    }
}
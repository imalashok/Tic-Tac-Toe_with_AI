import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.parse(new Scanner(System.in).nextLine());

        System.out.println((date.toLocalDate().getDayOfYear() - 1) * 24 + date.getHour());
    }
}
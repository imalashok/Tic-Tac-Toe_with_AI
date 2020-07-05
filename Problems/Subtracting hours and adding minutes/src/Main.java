import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        LocalDateTime inputDate = LocalDateTime.parse(line);

        System.out.print(inputDate.minusHours(scanner.nextInt()).plusMinutes(scanner.nextInt()));
    }
}
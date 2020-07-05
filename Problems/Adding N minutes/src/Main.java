import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime inputDate = LocalDateTime.parse(scanner.nextLine()).plusMinutes(scanner.nextInt());

        System.out.print(inputDate.getYear() + " ");
        System.out.print(inputDate.toLocalDate().getDayOfYear() + " ");
        System.out.print(inputDate.toLocalTime());
    }
}
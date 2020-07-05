import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int offset = scanner.nextInt();

        LocalDate firstDay = LocalDate.of(year, month, 1);

        System.out.println(firstDay.withDayOfMonth(firstDay.lengthOfMonth()).minusDays(offset - 1));
    }
}
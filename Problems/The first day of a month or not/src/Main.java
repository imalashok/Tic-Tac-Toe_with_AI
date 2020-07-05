import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.ofYearDay(scanner.nextInt(), scanner.nextInt());

        System.out.println(date == date.withDayOfMonth(1) ? "true" : "false");
    }
}
import java.time.DayOfWeek;
import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate firstDay = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);

        for (int i = 0; i < firstDay.lengthOfMonth(); i++) {
            LocalDate nextDay = firstDay.plusDays(i);
            if (nextDay.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(nextDay);
            }
        }
    }
}
import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate firstDay = LocalDate.parse(scanner.nextLine());
        int year = firstDay.getYear();
        int offset = scanner.nextInt();

        for (int i = 0; i < firstDay.lengthOfYear(); i += offset) {
            LocalDate nextDay = firstDay.plusDays(i);
            if (nextDay.getYear() == year) {
                System.out.println(nextDay);
            } else {
                break;
            }
        }
    }
}
import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        for (int i = 0; i < 3; i++) {
            System.out.println(LocalDate.ofYearDay(year, scanner.nextInt()));
        }
    }
}
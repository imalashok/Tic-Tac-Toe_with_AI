import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse(new Scanner(System.in).nextLine());
        System.out.println(date.minusYears(30) + "\n" + date.plusYears(30));
    }
}
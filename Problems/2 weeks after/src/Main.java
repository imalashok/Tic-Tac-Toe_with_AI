import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {

        System.out.println(LocalDate.parse(new Scanner(System.in).nextLine()).plusDays(14));
    }
}
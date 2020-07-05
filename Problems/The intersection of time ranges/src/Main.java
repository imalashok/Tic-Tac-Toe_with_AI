import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalTime date11 = LocalTime.parse(scanner.next());
        LocalTime date12 = LocalTime.parse(scanner.next());
        LocalTime date21 = LocalTime.parse(scanner.next());
        LocalTime date22 = LocalTime.parse(scanner.next());

        System.out.println((date11.compareTo(date21) >= 0 && date11.compareTo(date22) <= 0)
                || (date12.compareTo(date21) >= 0 && date12.compareTo(date22) <= 0)
                || (date21.compareTo(date11) >= 0 && date21.compareTo(date12) <= 0)
                || (date22.compareTo(date11) >= 0 && date22.compareTo(date12) <= 0));
    }
}
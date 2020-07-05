import java.util.Scanner;
import java.time.LocalTime;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime time = LocalTime.ofSecondOfDay(scanner.nextLong());
        System.out.print(time);
    }
}
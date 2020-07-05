import java.util.Scanner;
import java.time.LocalTime;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime time1 = LocalTime.parse(scanner.nextLine());
        System.out.print(time1.minusHours(scanner.nextInt()).minusMinutes(scanner.nextInt()));
    }
}
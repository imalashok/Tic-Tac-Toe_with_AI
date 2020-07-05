import java.util.Scanner;
import java.time.LocalTime;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime time = LocalTime.parse(scanner.nextLine());
        LocalTime newTime = LocalTime.of(time.getHour(), time.getMinute());
        System.out.print(newTime);
    }
}
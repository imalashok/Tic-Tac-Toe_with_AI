import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        LocalDateTime inputDate = LocalDateTime.parse(line[0]);

        System.out.print(inputDate.plusDays(Integer.parseInt(line[1])).minusHours(Integer.parseInt(line[2])));
    }
}
import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.parse(new Scanner(System.in).nextLine()).plusHours(11).toLocalDate());
    }
}
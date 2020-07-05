import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime first = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime second = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime temp;
        int cnt = 0;

        if (first.isAfter(second)) {
            temp = first;
            first = second;
            second = temp;
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < number; i++) {
            LocalDateTime next = LocalDateTime.parse(scanner.nextLine());
            if (next.compareTo(first) >= 0 && next.isBefore(second)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
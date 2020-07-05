import java.util.*;
import java.time.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> shops = new LinkedHashMap<>();
        LocalTime afterWork = LocalTime.of(19, 30);

        int numberOfShops = scanner.nextInt();

        for (int i = 0; i < numberOfShops; i++) {
            shops.put(scanner.next(), scanner.next());
        }

        for (var entry : shops.entrySet()) {
            if (afterWork.plusMinutes(30).isBefore(LocalTime.parse(entry.getValue()))) {
                System.out.println(entry.getKey());
            }
        }
    }
}
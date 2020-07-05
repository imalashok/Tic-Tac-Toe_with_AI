import java.time.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime dateTime2 = LocalDateTime.parse(scanner.nextLine());

        int days1 = dateTime1.toLocalDate().getDayOfYear();
        int hours1 = dateTime1.getHour();
        int minutes1 = dateTime1.getMinute();
        int seconds1 = dateTime1.getSecond();

        long inSeconds1 = days1 * 24 * 60 * 60 + hours1 * 60 * 60 + minutes1 * 60 + seconds1;


        int days2 = dateTime2.toLocalDate().getDayOfYear();
        int hours2 = dateTime2.getHour();
        int minutes2 = dateTime2.getMinute();
        int seconds2 = dateTime2.getSecond();

        long inSeconds2 = days2 * 24 * 60 * 60 + hours2 * 60 * 60 + minutes2 * 60 + seconds2;

        System.out.println(Math.abs(inSeconds1 - inSeconds2) / 3600);
    }
}
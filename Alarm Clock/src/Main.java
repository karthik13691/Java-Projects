import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String audioFile = args.length > 0 ? args[0] : "In The Morning - The Grey Room _ Clark Sims.wav";
        
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
                System.out.println("Enter an alarm time (HH:mm:ss):");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for: " + alarmTime);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }
        
        AlarmClock alarmClock = new AlarmClock(alarmTime, audioFile, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}
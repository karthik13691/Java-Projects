import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("\nAlarm! Wake up!");
        playMusic(filePath);
    }

    private void playMusic(String filePath) {
        File audioFile = new File(filePath);
        
        if (!audioFile.exists()) {
            System.out.println("Audio file not found: " + filePath);
            for (int i = 0; i < 5; i++) {
                System.out.print("\u0007");
                try { Thread.sleep(500); } catch (InterruptedException e) { 
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            return;
        }

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Press Enter to stop the alarm");
            scanner.nextLine();
            clip.stop();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
}
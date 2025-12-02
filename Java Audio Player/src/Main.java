import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Play Audio with Java (.wav, .au, .aiff)
        String filePath = "src/In The Morning - The Grey Room _ Clark Sims.wav";
        File file = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
             Scanner scanner = new Scanner(System.in)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";
            while (!response.equals("Q")) {
                System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                System.out.println("Enter your choice: ");

                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Not a valid response");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Line unavailable: " + e.getMessage());
        }
        finally {
            System.out.println("Done");
        }
    }
}

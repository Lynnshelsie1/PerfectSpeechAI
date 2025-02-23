import java.util.Scanner;

public class SpeechAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your speech transcription:");
        String transcription = scanner.nextLine();
        scanner.close();
        
        System.out.println("Transcription: " + transcription);
        analyzeSpeech(transcription);
    }

    private static void analyzeSpeech(String text) {
        int wordCount = text.split(" ").length;
        double speed = wordCount / 30.0; // Assuming 30 seconds speech

        System.out.println("Word Count: " + wordCount);
        if (speed > 3) {
            System.out.println("You're speaking too fast! Try slowing down.");
        } else if (speed < 1) {
            System.out.println("You're speaking too slow! Try increasing your pace.");
        } else {
            System.out.println("Perfect pace!");
        }
    }
}

package src;

import javax.sound.sampled.*;
import java.io.*;

public class AudioRecorder {
    public static void main(String[] args) {
        final int RECORD_TIME = 5000; // Record for 5 seconds
        File wavFile = new File("audio_files/recorded_audio.wav");

        AudioFormat format = new AudioFormat(16000, 16, 1, true, true);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

        try (TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info)) {
            line.open(format);
            line.start();

            System.out.println("Recording audio...");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTime < RECORD_TIME) {
                int bytesRead = line.read(buffer, 0, buffer.length);
                out.write(buffer, 0, bytesRead);
            }

            line.stop();
            System.out.println("Recording stopped.");

            // Save audio to WAV file
            try (FileOutputStream fos = new FileOutputStream(wavFile)) {
                fos.write(out.toByteArray());
                System.out.println("Saved as " + wavFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



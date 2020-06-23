package Daten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Wetter {

    private final int temperatur;
    private final int regenwahrscheinlichkeit;

    public Wetter(String daten) {
        String[] split = daten.split(" ");
        temperatur = Integer.parseInt(split[0]);
        regenwahrscheinlichkeit = Integer.parseInt(split[1]);
    }

    public boolean istHeiss() {
        return temperatur >= 29;
    }

    public boolean istKalt() {
        return temperatur < 15;
    }

    public boolean istTrocken() {
        return regenwahrscheinlichkeit < 30;
    }

    public boolean istNass() {
        return regenwahrscheinlichkeit > 80;
    }

    public static Wetter wetterDaten() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process process = null;
        try {
            process = processBuilder
                    .command("java", "-jar", "wetter.jar")
                    .redirectError(INHERIT)
                    .start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = in.readLine();
            process.waitFor(5, SECONDS);
            System.out.println("WETTER: "+line);
            return new Wetter(line);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new Wetter("20 50");
    }


}

package MailVersand;

import Daten.IKunde;
import Daten.Wetter;
import EssensTexte.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.time.DayOfWeek.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Mail implements IMail{
    private final String subject;
    private final String body;

    public Mail(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }


    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public static Mail createMail(String name) {
        Wetter wetter = Wetter.wetterDaten();
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek tag = now.getDayOfWeek();
        boolean frueh = now.getHour() > 6 && now.getHour() < 10;
        // Wetter Logic
        if (wetter.istHeiss() && wetter.istTrocken()) {
            if (frueh) {
                return new Grantina().granita(name);
            }
            return new Gelato().gelato(name);
        } else if (wetter.istKalt()) {
            return new WaffelnUndKaffee().waffelnUndKaffee(name);
        } else {
            if (tag.equals(SATURDAY) || tag.equals(SUNDAY)) {
                return new ZuppaInglese().zuppaInglese(name);
            }
            if (tag.equals(MONDAY) || tag.equals(WEDNESDAY)) {
                return new Cassata().cassata(name);
            }
            if (tag.equals(TUESDAY) || tag.equals(THURSDAY)) {
                return new Tiramisu().tiramisu(name);
            }
            if (tag.equals(FRIDAY)) {
                return new PannaCotta().pannaCotta(name);
            }
        }
        return new Mail("", "");
    }

    public static void sendMail(IKunde kunde) {
        IMail mail = createMail(kunde.getName());
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process process = null;
        try {
            process = processBuilder
                    .command("java", "-jar", "mail.jar", kunde.getEmail(), mail.getSubject(), mail.getBody())
                    .redirectOutput(INHERIT)
                    .redirectError(INHERIT)
                    .start();
            process.waitFor(5, SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

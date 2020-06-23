package EssensTexte;


import MailVersand.*;

public class Gelato extends EssenMailTexte{


	public Mail gelato(String name) {
			String subject = "Warm! Warm! Warm!";
			String body = String.format("Hallo %s,%n%n" +
					"ist dir auch so heiß? Wir haben genau das Richtige! Leckeres hausgemachtes Eis in Meisterqualität.%n%n" +
					"%n%nKomm einfach vorbei und kühl dich bei einem original italienischem Gelato ab.%n%n" +
					"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
			body += covid();
			return new Mail(subject, body);
		}

}

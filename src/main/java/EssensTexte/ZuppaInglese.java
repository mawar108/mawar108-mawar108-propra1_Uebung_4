package EssensTexte;

import MailVersand.Mail;

public class ZuppaInglese extends EssenMailTexte{


	public Mail zuppaInglese(String name) {
		String subject = "Tante Irma hat Zuppa Inglese gemacht";
		String body = String.format("Hallo %s,%n%n" +
				"dieses Wochenende hat Tante Irma ihre berühmte Zuppa Inglese gemacht. Lass dir die Spezialität aus Italiens Norden nicht entgehen.%n%n" +
				"%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}
}

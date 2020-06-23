package EssensTexte;

import MailVersand.Mail;

public class PannaCotta extends EssenMailTexte{

	public Mail pannaCotta(String name) {
		String subject = "Es gibt hausgemachte Panna Cotta";
		String body = String.format("Hallo %s,%n%nendlich ist Freitag! " +
				"Und zur Feier des Tages haben wir unsere hausgemachte Panna Cotta im Angebot.%n\n" +
				"Du hast die freie Wahl, ob du die original Panna Cotta mit herrlich frischem Kompptt " +
				"oder Caramellsoße haben willst.%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}

}

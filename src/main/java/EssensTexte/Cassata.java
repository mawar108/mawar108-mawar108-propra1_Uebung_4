package EssensTexte;

import MailVersand.Mail;

public class Cassata extends EssenMailTexte{

	public Mail cassata(String name) {
		String subject = "Die Bombe aus Italien: Cassata";
		String body = String.format("Hallo %s,%n%n" +
				"unser hausgemachtes Cassata Eis ist der original Cassata alla siciliana nachempfunden. Sie besteht aus  Himbeer-, Vanille- und Schokoladeneis sowie kandierten Früchten%n%n" +
				"%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}
}

package EssensTexte;

import MailVersand.Mail;

public class Tiramisu extends EssenMailTexte{


	public Mail tiramisu(String name) {
		String subject = "Magst du ein leckeres Tiramisu?";
		String body = String.format("Hallo %s,%n%n" +
				"kann es etwas besseres geben, als ein Tiramisu nach Originalrezept mit frischer Mascarpone Creme? Wir haben heute " +
				"den Klassiker aus Italien im Angebot. Eine herrlich süße Schleckerei, die wir gerne mit einer Tasse Cappucino servieren." +
				"%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}
}

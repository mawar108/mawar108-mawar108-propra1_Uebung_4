package EssensTexte;

import MailVersand.Mail;

public class Grantina extends EssenMailTexte{

	public Mail granita(String name) {
		String subject = "Frühstücken wie in Sizilien?";
		String body = String.format("Hallo %s,%n%n" +
				"Wenn es in Sizilien warm ist, dann frühstücken wir ein Granita al limone. Ein fruchtiges Zitronensorbet und dazu gibt es ein Brioche und Espresso.%n%n" +
				"%n%nKomm vorbei und starte den Tag wie im Urlaub.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}

}

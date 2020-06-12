package EssensTexte;

import MailVersand.Mail;

public class WaffelnUndKaffee extends EssenMailTexte{

	public Mail waffelnUndKaffee(String name) {
		String subject = "Mistwetter? Egal!";
		String body = String.format("Hallo %s,%n%n" +
				"lass dich vom Regen und der Kälte nicht runterziehen. Wir haben genau das Richtige! Leckere hausgemachte Waffeln und einen großen Pott Kaffee.%n%n" +
				"%n%nKomm einfach vorbei und nimm eine Auszeit.%n%n" +
				"Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
		body += covid();
		return new Mail(subject, body);
	}
}

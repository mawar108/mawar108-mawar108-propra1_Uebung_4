package EssensTexte;

import MailVersand.*;

public class EssenMailTexte {

	public Mail createSpezifischeMail(Boolean a, String name){
		return new Mail("", "");
	}

	//"Globale" Texte zum einfachen hinzufügen
	public String covid() {
		return "\n\nPS Wir haben natürlich alles für die Hygiene getan. Unsere Tische haben einen Mindestabstand von 2.5m, wir haben Scheiben zwischen den Tischen und alle unsere Bedienungen tragen Masken.";
	}


}

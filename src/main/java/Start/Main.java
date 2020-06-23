package Start;


import Daten.Kunde;
import MailVersand.*;

import java.util.List;

public class Main {

	private static final double CORONA_FACTOR = 0.13;
	public static final int SECHS_STUNDEN = 6 * 3600 * 1000;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Marketing Start");
		ICreateConnection m= new CreateConnection();

		while (true) {
			System.out.println("Starte Marketing.");
			List<Kunde> kunden = Kunde.getKunden(m.getConnection());
			for (Kunde k : kunden) {
				if (k.isReadyToReceiveMail() && Math.random() < CORONA_FACTOR) {
					m.sendMarketingMail(k);
				}
			}
			System.out.println("Fertig! Schlafe für 6 Stunden");
			Thread.sleep(SECHS_STUNDEN);
		}
	}
}

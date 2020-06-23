package MailVersand;

import Daten.Kunde;

import java.sql.Connection;

public interface ICreateConnection {
	public Connection getConnection();
	public void sendMarketingMail(Kunde kunde);
}

package MailVersand;


import Daten.Kunde;

import java.sql.*;

public class CreateConnection implements ICreateConnection {

	private Connection connection;

	public CreateConnection(){
		try {
			 this.connection = DriverManager.getConnection("jdbc:derby:kunden");
		} catch (SQLException throwables) {
			System.err.println("Datenbankverbindung konnte nicht hergestellt werden.");
			System.exit(-1);
		}
	}

	public Connection getConnection(){
		return this.connection;
	}

	public void sendMarketingMail(Kunde kunde) {
		kunde.updateLastMailDate(kunde, connection);
		Mail.sendMail(kunde);
	}

}

package Daten;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Kunde implements IKunde {

    private final long id;
    private final String name;
    private final String email;
    private LocalDate lastmail;

    public Kunde(long id, String name, String email, LocalDate lastmail) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastmail = lastmail;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    // Kunden werden maximal einmal pro 10 Tage angemailt!
    public boolean isReadyToReceiveMail() {
        long daysSinceLastMail = ChronoUnit.DAYS.between(lastmail, LocalDate.now());
        return daysSinceLastMail >= 10;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastmail=" + lastmail +
                '}';
    }

    public static List<Kunde> getKunden(Connection connection) {
        ArrayList<Kunde> kunden = new ArrayList<>();
        String sql = "SELECT * FROM kunden";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("mail");
                Date date = resultSet.getDate("lastmail");
                Kunde kunde = new Kunde(id, name, email, date.toLocalDate());
                kunden.add(kunde);
            }
        } catch (SQLException throwables) {
            System.err.println("Fehler beim Laden der Kundendaten");
            System.exit(-1);
        }
        return kunden;
    }

    public void updateLastMailDate(IKunde kunde, Connection connection) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE kunden SET lastmail = CURRENT_DATE WHERE id = ?");
            stmt.setLong(1, kunde.getId());
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

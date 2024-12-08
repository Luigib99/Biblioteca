package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class QueryRepository {

    //READ
    public ArrayList<Utente> query1(Utente utente) {
        ArrayList<Utente> listaLibriUtente = new ArrayList<>();
        String query =
                "SELECT U.nome,U.cognome,L.titolo,L.autore,O.dataInizio, O.dataFine " +
                        "FROM Ordine O " +
                        "JOIN Libro L " +
                        "ON O.idLibro=L.idLibro " +
                        "JOIN Utente U " +
                        "ON O.idUtente=U.id " +
                        "WHERE U.id = " + utente.getId() + " "+
                        "ORDER BY O.dataInizio ASC;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ordine ordine = new Ordine();
                Libro libro = new Libro();

                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {ordine.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataInizio != null) {ordine.setDataFine(dataFine.toLocalDate());}listaLibriUtente.add(utente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaLibriUtente;
    }
}
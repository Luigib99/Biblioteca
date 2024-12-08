package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;

public class QueryRepository {

    //QUERY1
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
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));

                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));

                Ordine ordine = new Ordine();
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {ordine.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {ordine.setDataFine(dataFine.toLocalDate());}

                utente.addLibro(libro);
                utente.addOrdine(ordine);

                listaLibriUtente.add(utente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaLibriUtente;
    }

    //QUERY2
    public ArrayList<Libro> query2() {
        ArrayList<Libro> listaLibriNonTornati = new ArrayList<>();
        String query =
                "SELECT L.titolo,L.autore " +
                        "FROM Libro L " +
                        "JOIN Ordine O " +
                        "ON O.idLibro=L.idLibro " +
                        "WHERE O.dataFine isnull";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));

                listaLibriNonTornati.add(libro);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaLibriNonTornati;
    }

    //QUERY3 X
    public ArrayList<Ordine> query3(LocalDate dataScelta){
    ArrayList<Ordine> listaOrdiniPeriodo = new ArrayList<>();
    String query =
            "SELECT U.nome,U.cognome,L.titolo,L.autore,O.dataInizio, O.dataFine " +
                    "FROM Ordine O " +
                    "JOIN Libro L " +
                    "ON O.idLibro=L.idLibro " +
                    "JOIN Utente U " +
                    "ON O.idUtente=U.id " +
                    "WHERE O.dataInizio > '"+ dataScelta +"'";
        try {
        Connection c = DbConnection.openConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Utente utente = new Utente();
            utente.setNome(rs.getString("nome"));
            utente.setCognome(rs.getString("cognome"));

            Libro libro = new Libro();
            libro.setTitolo(rs.getString("titolo"));
            libro.setAutore(rs.getString("autore"));

            Ordine ordine = new Ordine();
            Date dataInizio = rs.getDate("dataInizio");
            if (dataInizio != null) {ordine.setDataInizio(dataInizio.toLocalDate());}
            Date dataFine = rs.getDate("dataFine");
            if (dataFine != null) {ordine.setDataFine(dataFine.toLocalDate());}

            ordine.addUtente(utente);
            ordine.addLibro(libro);

            listaOrdiniPeriodo.add(ordine);
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println(e.getMessage());
        System.exit(0);
    }
        return listaOrdiniPeriodo;
    }

    //QUERY4 X
    public ArrayList<Ordine> query4(){
        ArrayList<Ordine> listaOrdiniPeriodo = new ArrayList<>();
        String query =
                "SELECT U.nome,U.cognome,L.titolo,L.autore,O.dataInizio, O.dataFine " +
                        "FROM Ordine O " +
                        "JOIN Libro L " +
                        "ON O.idLibro=L.idLibro " +
                        "JOIN Utente U " +
                        "ON O.idUtente=U.id " +
                        "WHERE O.dataFine - dataInizio> 15";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Utente utente = new Utente();
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));

                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));

                Ordine ordine = new Ordine();
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {ordine.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {ordine.setDataFine(dataFine.toLocalDate());}

                ordine.addUtente(utente);
                ordine.addLibro(libro);

                listaOrdiniPeriodo.add(ordine);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaOrdiniPeriodo;
    }

    //QUERY 5
    public ArrayList<Utente> query5()
    {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        String query =
                "SELECT u.nome, u.cognome, COUNT(o.idutente) AS libriLetti " +
                        "FROM Ordine o " +
                        "JOIN Utente u ON u.id = o.idUtente " +
                        "GROUP BY u.nome,u.cognome, o.idUtente " +
                        "ORDER BY COUNT (o.idUtente) desc " +
                        "LIMIT 3;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Utente utente = new Utente();
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));

                listaUtenti.add(utente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaUtenti;
    }

    //QUERY 6
    public ArrayList<Libro> query6()
    {
        ArrayList<Libro> listaLibri = new ArrayList<>();
        String query =
                "SELECT l.titolo, l.autore, COUNT(o.idLibro) AS numeroDiVoltePrestato " +
                        "FROM Libro l " +
                        "JOIN Ordine o ON l.idLibro = o.idLibro " +
                        "GROUP BY l.titolo, l.autore, o.idLibro " +
                        "ORDER BY COUNT (o.idLibro) desc ";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));

                listaLibri.add(libro);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaLibri;
    }
}
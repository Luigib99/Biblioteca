package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class UtenteRepository {

    //CREATE
    public void create(Utente utente) {
        String query =
                "INSERT INTO Utente " +
                        "(cognome,nome) "+
                        "VALUES " +
                        "('" + utente.getNome() +"','"+utente.getCognome()+"')";
        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //READ
    public ArrayList<Utente> readUtente() {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        String query =
                "SELECT id,nome,cognome "+
                        "FROM Utente "+
                        "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Utente utente = new Utente();
                //creo le associazioni con la tabella
                utente.setId(rs.getInt("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                //aggiungo l'utente alla lista
                listaUtenti.add(utente);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaUtenti;
    }

    //DELETE
    public void deleteUtente(Utente utente)
    {
        String query =
                "DELETE FROM Utente " +
                        "WHERE id = '" + utente.getId() + "'";

        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //UPDATE
    public void updateUtente(Utente utente)
    {
        String query =
                "UPDATE Utente " +
                        "SET nome = '" + utente.getNome() + "', " +
                        "cognome = '" + utente.getCognome() + "' "+
                        "WHERE id = " + utente.getId();

        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}

package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class Repository {

    //CREATE
    public void create(Utente utente) {
        //da modificare
        String query =
                "INSERT INTO Utente " +
                        "(colonna1,colonna2,colonna3) "+
                        "VALUES " +
                        "('" + utente.getElemento1() +"','"+utente.getElemento2() +"','" + utente.getElemento3() +"')";
        //resta invariato
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
    public ArrayList<Utente> readOggetto() {
        ArrayList<Utente> listaOggetti = new ArrayList<>();
        String query =
                "SELECT id,elemento1,elemento2,elemento3 "+
                        "FROM Utente "+
                        "ORDER BY a.id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Utente utente = new Utente();
                //creo le associazioni con la tabella
                utente.setElemento1(rs.getString("elemento1"));
                utente.setElemento2(rs.getString("elemento2"));
                utente.setElemento2(rs.getString("elemento3"));

                /* LA LOCAL DATE SI FA COSI
                Date data = rs.getDate("data");
                if (data != null)
                {
                    utente.setData(data.toLocalDate());
                }*/

                //aggiungo l'utente alla lista
                listaOggetti.add(utente);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaOggetti;
    }


    //DELETE
    public void delete(Utente utente)
    {
        //Da modificare
        String query =
                "DELETE FROM Utente " +
                        "WHERE id = '" + utente.getId() + "'";

        //resta invariato
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
    public void updateOggetto(Utente utente)
    {
        //Da modificare
        String query =
                "UPDATE Utente " +
                        "SET colonna1 = '" + utente.getElemento1() + "', " +
                        "colonna2 = '" + utente.getElemento2() + "' "+
                        "WHERE id = " + utente.getId();

        //Resta invariato
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

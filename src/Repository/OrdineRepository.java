package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class OrdineRepository {

    //CREATE
    public void createOrdine(Ordine ordine) {
        String query =
                "INSERT INTO Ordine " +
                        "(idLibro,idUtente,dataInizio,dataFine) "+
                        "VALUES " +
                        "('" + ordine.getIdLibro() +"','"+ordine.getIdUtente() +"','" + ordine.getDataInizio() +"','" + ordine.getDataFine() +"')";
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
    public ArrayList<Ordine> readOrdine() {
        ArrayList<Ordine> listaOrdini = new ArrayList<>();
        String query =
                    "SELECT id,idLibro,idUtente,dataInizio,dataFine "+
                            "FROM Ordine "+
                            "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {

                //creo l'istanza
                Ordine ordine = new Ordine();

                //creo le associazioni con la tabella
                ordine.setId(rs.getInt("id"));
                ordine.setIdLibro(rs.getString("idLibro"));
                ordine.setIdUtente(rs.getInt("idUtente"));
                Date dataInizio = rs.getDate("dataInizio");
                if (dataInizio != null) {ordine.setDataInizio(dataInizio.toLocalDate());}
                Date dataFine = rs.getDate("dataFine");
                if (dataFine != null) {ordine.setDataFine(dataFine.toLocalDate());}
                listaOrdini.add(ordine);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaOrdini;
    }

    //DELETE
    public void deleteOrdine(Ordine ordine)
    {
        String query =
                "DELETE FROM Ordine " +
                        "WHERE id = '" + ordine.getId() + "'";

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
    public void updateOrdine(Ordine ordine)
    {
        String query =
                "UPDATE Ordine " +
                        "SET idLibro = '" + ordine.getIdLibro() + "', " +
                        "idUtente = '" + ordine.getIdUtente() + "', "+
                        "dataInizio = '" + ordine.getDataInizio() + "', " +
                        "dataFine = '" + ordine.getDataFine() + "' " +
                        "WHERE id = " + ordine.getId();

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


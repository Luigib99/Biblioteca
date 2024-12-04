package Repository;
import Config.DbConnection;
import Entity.*;
import java.util.ArrayList;
import java.sql.*;

public class LibroRepository {

    //CREATE
    public void createLibro(Libro libro) {
        String query =
                "INSERT INTO Libro " +
                        "(idLibro,titolo,autore) "+
                        "VALUES " +
                        "('"+libro.getIdLibro() +"','" + libro.getTitolo()+"','"+libro.getAutore()+"')";
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
    public ArrayList<Libro> readLibro() {
        ArrayList<Libro> listaLibri = new ArrayList<>();
        String query =
                "SELECT id,idLibro,titolo,autore "+
                "FROM Libro "+
                "ORDER BY id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza
                Libro libro = new Libro();
                //creo le associazioni con la tabella
                libro.setId(rs.getInt("id"));
                libro.setIdLibro(rs.getString("idLibro"));
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));
                //aggiungo l'oggetto alla lista
                listaLibri.add(libro);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaLibri;
    }

    //DELETE
    public void deleteLibro(Libro libro)
    {
        String query =
                "DELETE FROM Libro " +
                        "WHERE id = '" + libro.getId() + "'";

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
    public void updateLibro(Libro libro)
    {
        String query =
                "UPDATE Libro " +
                        "SET idLibro = '" + libro.getIdLibro() + "', " +
                        "titolo = '" + libro.getTitolo() + "', "+
                        "autore = '" + libro.getAutore() + "' "+
                        "WHERE id = " + libro.getId();

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

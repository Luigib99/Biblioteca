package Entity;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private int id;
    private String idLibro;
    private String titolo;
    private String autore;
    private List <Utente> utenti;

    public Libro()
    {
        this.id = id;
        this.idLibro = idLibro;
        this.titolo = titolo;
        this.autore = autore;
        this.utenti = new ArrayList<Utente>();
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId ()
    {
        return id;
    }

    public String getIdLibro()
    {
        return idLibro;
    }

    public void setIdLibro(String idLibro)
    {
        this.idLibro = idLibro;
    }

    public String getTitolo ()
    {
        return titolo;
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public String getAutore()
    {
        return autore;
    }

    public void setAutore(String autore)
    {
        this.autore = autore;
    }

    public List getUtenti(ArrayList<Utente> utenti)
    {
        return utenti;
    }

}

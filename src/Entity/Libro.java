package Entity;

public class Libro {
    private int id;
    private String idLibro;
    private String titolo;
    private String autore;

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
}

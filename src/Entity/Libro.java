package Entity;

import java.util.List;

public class Libro {
    private int id;
    private String idLibro;
    private String titolo;
    private String autore;
    private List<Utente> listaUtenti;
    private List <Ordine> listaOrdini;

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

    //LIST

    public void addOrdine(Ordine ordine)
    {
        this.listaOrdini.add(ordine);
    }

    public List<Ordine> getOrdini()
    {
        return listaOrdini;
    }

    public void addUtente(Utente utente)
    {
        this.listaUtenti.add(utente);
    }

    public List<Utente> getutenti()
    {
        return listaUtenti;
    }
}

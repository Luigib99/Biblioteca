package Entity;

import java.util.ArrayList;
import java.util.List;

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private List <Ordine> listaOrdini = new ArrayList<>();
    private List <Libro> listaLibri = new ArrayList<>();


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
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

    public void addLibro(Libro libro)
    {
        this.listaLibri.add(libro);
    }

    public List<Libro> getLibro()
    {
        return listaLibri;
    }
}

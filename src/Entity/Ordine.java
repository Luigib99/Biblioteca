package Entity;

import java.time.LocalDate;
import java.util.List;

public class Ordine {
    private int id;
    private String idLibro;
    private int idUtente;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List <Utente> listaUtenti;
    private List <Libro> listaLibri;

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIdLibro()
    {
        return idLibro;
    }

    public void setIdLibro (String idLibro)
    {
        this.idLibro = idLibro;
    }

    public int getIdUtente()
    {
        return idUtente;
    }

    public void setIdUtente(int idUtente)
    {
        this.idUtente = idUtente;
    }

    public LocalDate getDataInizio()
    {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio)
    {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine()
    {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine)
    {
        this.dataFine = dataFine;
    }

    //LIST

    public void addUtente(Utente utente)
    {
        this.listaUtenti.add(utente);
    }

    public List<Utente> getUtenti()
    {
        return listaUtenti;
    }

    public void addLibro(Libro libro)
    {
        this.listaLibri.add(libro);
    }

    public List<Libro> getLibri()
    {
        return listaLibri;
    }


}

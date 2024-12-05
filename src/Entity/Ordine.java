package Entity;

import java.time.LocalDate;

public class Ordine {
    private int id;
    private String idLibro;
    private int idUtente;
    private LocalDate dataInizio;
    private LocalDate dataFine;

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
}

package Entity;

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private Utente utente;

    public Utente()
    {
        this.nome=nome;
        this.cognome=cognome;
    }

    public int getId()
    {
        return id;
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
}

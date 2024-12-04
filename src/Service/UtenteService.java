package Service;

import Entity.Utente;
import Repository.UtenteRepository;
import java.util.List;

public class UtenteService {

    UtenteRepository utenteRepository = new UtenteRepository();

    public void createUtente(String nome, String cognome)
    {
        Utente utente = new Utente();

        utente.setNome(nome);
        utente.setCognome(cognome);

        utenteRepository.create(utente);
    }

    public void updateUtente (int id, String nome, String cognome)
    {
        Utente utente = new Utente();

        utente.setId(id);
        utente.setNome(nome);
        utente.setCognome(cognome);

        utenteRepository.updateUtente(utente);
    }

    public List<Utente> readUtente()
    {
        return utenteRepository.readUtente();
    }

    public void deleteUtente(int id)
    {
        Utente utente = new Utente();

        utente.setId(id);
        utenteRepository.deleteUtente(utente);
    }
}

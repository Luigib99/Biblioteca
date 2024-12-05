package Service;
import Entity.*;
import Repository.OrdineRepository;

import java.time.LocalDate;
import java.util.List;

public class OrdineService {
    OrdineRepository ordineRepository = new OrdineRepository();

    public void createOrdine(String idLibro, int idUtente, LocalDate dataInizio, LocalDate dataFine)
    {
        Ordine ordine = new Ordine();

        ordine.setIdLibro(idLibro);
        ordine.setIdUtente(idUtente);
        ordine.setDataInizio(dataInizio);
        ordine.setDataFine(dataFine);
        ordineRepository.createOrdine(ordine);
    }

    public List <Ordine> readOrdine ()
    {
        return ordineRepository.readOrdine();
    }

    public void updateOrdine (int id,String idLibro, int idUtente, LocalDate dataInizio, LocalDate dataFine)
    {
        Ordine ordine = new Ordine();
        ordine.setId(id);
        ordine.setIdLibro(idLibro);
        ordine.setIdUtente(idUtente);
        ordine.setDataInizio(dataInizio);
        ordine.setDataFine(dataFine);
        ordineRepository.updateOrdine(ordine);
    }

    public void deleteOrdine(int id)
    {
        Ordine ordine = new Ordine();
        ordine.setId(id);
        ordineRepository.deleteOrdine(ordine);
    }
}

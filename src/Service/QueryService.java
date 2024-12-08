package Service;
import Repository.*;
import Entity.*;

import java.time.LocalDate;
import java.util.List;

public class QueryService {
    QueryRepository queryRepository = new QueryRepository();

    public List<Utente> query1(Utente utente)
    {
        return queryRepository.query1(utente);
    }

    public List<Libro> query2()
    {
        return queryRepository.query2();
    }

    public List<Ordine> query3(LocalDate dataScelta)
    {
        return queryRepository.query3(dataScelta);
    }

    public List<Ordine> query4()
    {
        return queryRepository.query4();
    }

    public List<Utente> query5()
    {
        return queryRepository.query5();
    }

    public List<Libro> query6()
    {
        return queryRepository.query6();
    }
}

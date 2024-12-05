package Service;
import Repository.*;
import Entity.*;

import java.util.List;

public class QueryService {
    QueryRepository queryRepository = new QueryRepository();

    public List<Utente> query1(Utente utente)
    {
        return queryRepository.query1(utente);
    }

}

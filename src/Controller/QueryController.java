package Controller;
import Service.*;
import Entity.*;
import Controller.*;

import java.util.List;
import java.util.Scanner;

public class QueryController {
    Scanner scanner = new Scanner(System.in);
    UtenteController utenteController = new UtenteController();
    UtenteService utenteService = new UtenteService();
    QueryService queryService = new QueryService();
    LibroService libroService = new LibroService();
    OrdineService ordineService = new OrdineService();

    public void query1()
    {
        System.out.println("Inserisci l'id dell'utente di cui vedere gli ordini");
        utenteController.readUtente();
        int idScelto=scanner.nextInt();
        scanner.nextLine();

        //mi prendo l'utente
        Utente UtenteScelto = new Utente();
        List<Utente> listaUtenti = utenteService.readUtente();
        for(Utente utente : listaUtenti)
        {
            if (utente.getId() == idScelto)
            {
                UtenteScelto = utente;
            }
        }
        List <Utente> listaUtentiScelti = queryService.query1(UtenteScelto);
        for (Utente utente : listaUtentiScelti)
        {
            System.out.println(utente.getNome() + " " + utente.getCognome() + utente.getLibro() + " " + utente.getOrdini());
        }

    }
}

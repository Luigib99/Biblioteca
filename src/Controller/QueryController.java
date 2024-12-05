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
        List <Libro> listaLibri = libroService.readLibro();
        List <Ordine> listaOrdini = ordineService.readOrdine();
        for (Utente utente : listaUtentiScelti)
        {
            System.out.println(utente.getNome() + " " + utente.getCognome());
        }

    }
}

package Controller;
import Service.*;
import Entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class QueryController {
    Scanner scanner = new Scanner(System.in);
    UtenteController utenteController = new UtenteController();
    UtenteService utenteService = new UtenteService();
    QueryService queryService = new QueryService();

    public void query1()
    {
        System.out.println("Inserisci l'id dell'utente di cui vedere gli ordini");
        utenteController.readUtente();
        int idScelto=scanner.nextInt();
        scanner.nextLine();

        //mi prendo l'utente
        Utente utenteScelto = new Utente();
        List<Utente> listaUtenti = utenteService.readUtente();
        for(Utente utente : listaUtenti)
        {
            if (utente.getId() == idScelto)
            {
                utenteScelto = utente;
            }
        }
        List <Utente> listaUtentiScelti = queryService.query1(utenteScelto);
        System.out.println(utenteScelto.getNome() + " " + utenteScelto.getCognome() + " ");
        for (int i=0;i<listaUtentiScelti.size();i++)
        {
            List <Libro> listaLibriUtenti = utenteScelto.getLibro();
            System.out.print(listaLibriUtenti.get(i).getTitolo() + " ");
            List <Ordine> listaOrdiniUtente = utenteScelto.getOrdini();
            System.out.print(listaOrdiniUtente.get(i).getDataInizio() + " " + listaOrdiniUtente.get(i).getDataFine()+"\n");
        }
    }

    public void query2()
    {
        System.out.println("LISTA LIBRI NON RIENTRATI");
        List<Libro> listaLibriNonRientrati = queryService.query2();
        for (Libro libro : listaLibriNonRientrati)
        {
            System.out.println(libro.getTitolo() + " " + libro.getAutore());
        }
    }

    public void query3 ()
    {
        System.out.println("DIGITA UN PERIODO DA CUI VUOI VEDERE GLI ORDINI (yyyy-mm-dd)");
        LocalDate dataScelta = LocalDate.parse(scanner.nextLine());
        List <Ordine> listaOrdiniPeriodo = queryService.query3(dataScelta);
        for (int i=0; i<listaOrdiniPeriodo.size();i++)
        {
            Ordine ordine = listaOrdiniPeriodo.get(i);
            List<Utente> utenti = ordine.getUtenti();
            Utente utente = utenti.get(i);
            List<Libro> libri = ordine.getLibri();
            Libro libro = libri.get(i);
            System.out.println(utente.getNome() + " " + utente.getCognome() + " " + libro.getTitolo() + " " + libro.getAutore() + " " + ordine.getDataInizio() + ordine.getDataFine());
        }

    }

    public void query4 ()
    {
        List<Ordine> listaOrdini = queryService.query4();
        for (int i = 0; i < listaOrdini.size(); i++) {
            Ordine ordine = listaOrdini.get(i);
            List<Utente> utenti = ordine.getUtenti();
            Utente utente = utenti.get(i);
            List<Libro> libri = ordine.getLibri();
            Libro libro = libri.get(i);
            if (ordine.getDataFine() != null) {
                System.out.println(utente.getNome() + " " + utente.getCognome() + " " + libro.getTitolo() + " " + libro.getAutore() + " " + ordine.getDataInizio() + ordine.getDataFine());
            }
        }
    }

    public void query5()
    {
        List<Utente> listaUtenti = queryService.query5();
        System.out.println("UTENTI CON PIU ORDINI REALIZZATI");
        for (Utente utente : listaUtenti)
        {
            System.out.println(utente.getNome() + " " + utente.getCognome());
        }
    }

    public void query6()
    {
        List<Libro> listaLibri = queryService.query6();
        System.out.println("LIBRI CON PIU ORDINI RICEVUTI");
        for (Libro libro : listaLibri)
        {
            System.out.println(libro.getTitolo() + " " + libro.getAutore());
        }
    }
}

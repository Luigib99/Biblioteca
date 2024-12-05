package Controller;
import Entity.*;
import Service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrdineController {
    Scanner scanner = new Scanner(System.in);
    OrdineService ordineService = new OrdineService();
    LibroController libroController = new LibroController();
    UtenteController utenteController = new UtenteController();
    LibroService libroService = new LibroService();

    //CREATE
    public void createOrdine()
    {
        System.out.println("Inserisci l'id del libro dalla lista");
        libroController.readLibro();
        String idLibro = "0";
        int idSelezionato=scanner.nextInt();
        List<Libro> listaLibri = libroService.readLibro();
        for (Libro libro : listaLibri)
        {
            if (idSelezionato == libro.getId())
            {
                idLibro = libro.getIdLibro();
            }
        }
        System.out.println("Inserisci l'id dell'utente dalla lista");
        utenteController.readUtente();
        int idUtente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci la data di inizio (yyyy-mm-dd)");
        LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
        System.out.println("Il libro è stato riconsegnato (y/n)?");
        String riconsegnato = scanner.nextLine();
        LocalDate dataFine=null;
        if (riconsegnato.equals("y"))
        {
            System.out.println("Inserisci la data di consegna(yyyy-mm-dd)");
            {
                dataFine = LocalDate.parse(scanner.nextLine());
            }
        }
        ordineService.createOrdine(idLibro,idUtente,dataInizio,dataFine);
    }

    //READ
    public void readOrdine()
    {
        List<Ordine> listaOrdini = ordineService.readOrdine();
        {
            for (Ordine ordine : listaOrdini)
            {
                System.out.println(ordine.getId() + " " +
                        ordine.getIdUtente() + " " +
                        ordine.getDataInizio() + " " +
                        ordine.getDataFine());
            }
        }
    }

    //UPDATE
    public void updateOrdine()
    {
        System.out.println("Inserisci l'id dell'ordine da modificare dalla lista");
        readOrdine();
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il nuovo id del libro dalla lista");
        libroController.readLibro();
        String idLibro = "0";
        int idSelezionato=scanner.nextInt();
        List<Libro> listaLibri = libroService.readLibro();
        for (Libro libro : listaLibri)
        {
            if (idSelezionato == libro.getId())
            {
                idLibro = libro.getIdLibro();
            }
        }
        System.out.println("Inserisci il nuovo id dell'utente dalla lista");
        utenteController.readUtente();
        int idUtente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci la nuova data di inzio (yyyy-mm-dd)");
        LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
        System.out.println("Il libro è stato riconsegnato (y/n)?");
        String riconsegnato = scanner.nextLine();
        LocalDate dataFine=null;
        if (riconsegnato.equals("y"))
        {
            System.out.println("Inserisci la nuova data di consegna");
            {
                dataFine = LocalDate.parse(scanner.nextLine());
            }
        }
        else if (riconsegnato.equals("n"))
        {
            dataFine= LocalDate.parse(null);
        }
        ordineService.updateOrdine(id,idLibro,idUtente,dataInizio,dataFine);
    }

    //DELETE
    public void deleteOrdine()
    {
        System.out.println("Inserisci l'id dell'ordine da elimianre dalla lista");
        readOrdine();
        int id = scanner.nextInt();
        ordineService.deleteOrdine(id);
    }

}

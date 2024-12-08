package Controller;
import Service.UtenteService;
import Entity.Utente;
import java.util.Scanner;
import java.util.List;

public class UtenteController {
    Scanner scanner = new Scanner(System.in);
    UtenteService utenteService = new UtenteService();

    public void createUtente()
    {
        System.out.println("Inserisci il nome dell'utente");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome");
        String cognome = scanner.nextLine();
        utenteService.createUtente(nome,cognome);
    }

    public void updateUtente()
    {
        System.out.println("seleziona l'utente da modificare dall'id");
        readUtente();
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il nuovo nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il nuovo cognome");
        String cognome = scanner.nextLine();

        utenteService.updateUtente(id,nome,cognome);
    }

    public void readUtente()
    {
        List <Utente> listaUtenti = utenteService.readUtente();
        for (Utente utente : listaUtenti)
        {
            System.out.println(utente.getId() + " " + utente.getNome() + " " + utente.getCognome());
        }
    }

    public void deleteUtente()
    {
        System.out.println("seleziona l'utente da eliminare dall'id");
        readUtente();
        int id = scanner.nextInt();

        utenteService.deleteUtente(id);
    }
}

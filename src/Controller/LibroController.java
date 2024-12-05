package Controller;
import Entity.*;

import Service.LibroService;

import java.util.List;
import java.util.Scanner;

public class LibroController {
    Scanner scanner = new Scanner(System.in);
    LibroService libroService = new LibroService();

    //CREATE
    public void createLibro()
    {
        System.out.println("Inserisci l'id del libro");
        String idLibro=scanner.nextLine();
        System.out.println("Inserisci il titolo");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci l'autore");
        String autore = scanner.nextLine();
        libroService.createLibro(idLibro, titolo, autore);
    }

    //READ
    public void readLibro()
    {
        List<Libro> listaLibri = libroService.readLibro();
        for (Libro libro : listaLibri)
        {
            System.out.println(libro.getId() + " " +
                    libro.getIdLibro() + " " +
                    libro.getTitolo() + " " +
                    libro.getAutore());
        }
    }

    //UPDATE
    public void updateLibro()
    {
        System.out.println("Inserisci l'id del libro da modificare dalla lista\n");
        readLibro();
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci il nuovo id del libro");
        String idLibro = scanner.nextLine();
        System.out.println("Inserisci il nuovo titolo");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci il nuovo autore");
        String autore = scanner.nextLine();

        libroService.updateLibro(id,idLibro, titolo, autore);
    }

    //DELETE
    public void deleteLibro()
    {
        System.out.println("Inserisci l'id del libro da eliminare dalla lista\n");
        readLibro();
        int id = scanner.nextInt();
        libroService.deleteLibro(id);
    }
}

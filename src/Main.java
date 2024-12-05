import Controller.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibroController libroController = new LibroController();
        UtenteController utenteController = new UtenteController();
        OrdineController ordineController = new OrdineController();
        QueryController queryController = new QueryController();
        int choice1;
        int choice2;

        do
        {
            System.out.println("+++MENU INIZIALE+++");
            System.out.println("Scegli cosa fare digitando il numero");
            System.out.println("1) LIBRI");
            System.out.println("2) UTENTI");
            System.out.println("3) ORDINI");
            System.out.println("4) QUERY");
            System.out.println("9) ESCI");
            choice1 = scanner.nextInt();
            if (choice1 == 1)
            {
                do
                {
                    System.out.println("---LIBRO---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        libroController.createLibro();
                    }
                    else if (choice2 == 2)
                    {
                        libroController.updateLibro();
                    }
                    else if (choice2 == 3)
                    {
                        libroController.readLibro();
                    }
                    else if (choice2 == 4)
                    {
                        libroController.deleteLibro();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==1);
            }
            else if (choice1 == 2)
            {
                do
                {
                    System.out.println("---UTENTE---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("5) LIBRI PER UTENTE");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        utenteController.createUtente();
                    }
                    else if (choice2 == 2)
                    {
                        utenteController.updateUtente();
                    }
                    else if (choice2 == 3)
                    {
                        utenteController.readUtente();
                    }
                    else if (choice2 == 4)
                    {
                        utenteController.deleteUtente();
                    }
                    else if (choice2 ==5)
                    {
                        utenteController.readLibriUtente();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==2);
            }
            else if (choice1 == 3)
            {
                do
                {
                    System.out.println("---ORDINI---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) CREA");
                    System.out.println("2) MODIFICA");
                    System.out.println("3) LEGGI");
                    System.out.println("4) ELIMINA");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        ordineController.createOrdine();
                    }
                    else if (choice2 == 2)
                    {
                        ordineController.updateOrdine();
                    }
                    else if (choice2 == 3)
                    {
                        ordineController.readOrdine();
                    }
                    else if (choice2 == 4)
                    {
                        ordineController.deleteOrdine();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==3);
            }
            else if (choice1 == 4)
            {
                do
                {
                    System.out.println("---QUERY---");
                    System.out.println("Scegli cosa fare digitando il numero");
                    System.out.println("1) ORDINI PER UTENTE IN ORDINE CRONOLOGICO");
                    System.out.println("9) INDIETRO");

                    choice2 = scanner.nextInt();

                    if (choice2 == 1)
                    {
                        queryController.query1();
                    }
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                }
                while (choice1 ==4);
            }
        }
        while (choice1 != 9);
        scanner.close();
    }
}
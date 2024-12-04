import Controller.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibroController libroController = new LibroController();
        UtenteController utenteController = new UtenteController();
        int choice1;
        int choice2;

        System.out.println("+++MENU INIZIALE+++");
        System.out.println("Scegli cosa fare digitando il numero");
        System.out.println("1) LIBRO");
        System.out.println("2) UTENTI");
        System.out.println("9) ESCI");
        choice1 = scanner.nextInt();
        do
        {
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
                    }
                }
                while (choice2 !=9);
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
                    else if (choice2 ==9)
                    {
                        System.out.println("\nINDIETRO\n");
                    }
                }
                while (choice2 !=9);
            }
        }
        while (choice1 != 9);
        scanner.close();
    }
}
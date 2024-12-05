package Service;
import Entity.*;
import Repository.LibroRepository;

import java.util.List;

public class LibroService {
    LibroRepository libroRepository = new LibroRepository();

    //CREATE
    public void createLibro(String idLibro, String titolo, String autore)
    {
        Libro libro = new Libro();

        libro.setIdLibro(idLibro);
        libro.setTitolo(titolo);
        libro.setAutore(autore);

        libroRepository.createLibro(libro);
    }

    //READ
    public List<Libro> readLibro()
    {
        return libroRepository.readLibro();
    }

    //UPDATE
    public void updateLibro(int id, String idLibro, String titolo, String autore)
    {
        Libro libro = new Libro();

        libro.setId(id);
        libro.setIdLibro(idLibro);
        libro.setTitolo(titolo);
        libro.setAutore(autore);

        libroRepository.updateLibro(libro);
    }

    //DELETE
    public void deleteLibro(int id)
    {
        Libro libro = new Libro();

        libro.setId(id);
        libroRepository.deleteLibro(libro);
    }
}

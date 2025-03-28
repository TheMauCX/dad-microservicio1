package pe.edu.upeu.ms_catalogo_productos.service;

import pe.edu.upeu.ms_catalogo_productos.domain.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    Libro create(Libro c);
    Libro update(Libro c);
    void delete(Long id);
    Optional<Libro> read(Long id);
    List<Libro> readAll();
}

package pe.edu.upeu.ms_catalogo_productos.service;

import pe.edu.upeu.ms_catalogo_productos.domain.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    Autor create(Autor c);
    Autor update(Autor c);
    void delete(Long id);
    Optional<Autor> read(Long id);
    List<Autor> readAll();
}

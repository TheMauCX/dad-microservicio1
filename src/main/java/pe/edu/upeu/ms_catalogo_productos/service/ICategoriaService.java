package pe.edu.upeu.ms_catalogo_productos.service;

import pe.edu.upeu.ms_catalogo_productos.domain.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    Categoria create(Categoria c);
    Categoria update(Categoria c);
    void delete(Long id);
    Optional<Categoria> read(Long id);
    List<Categoria> readAll();
}

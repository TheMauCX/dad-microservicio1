package pe.edu.upeu.ms_catalogo_productos.service;

import pe.edu.upeu.ms_catalogo_productos.domain.Editorial;

import java.util.List;
import java.util.Optional;

public interface IEditorialService {
    Editorial create(Editorial c);
    Editorial update(Editorial c);
    void delete(Long id);
    Optional<Editorial> read(Long id);
    List<Editorial> readAll();
}

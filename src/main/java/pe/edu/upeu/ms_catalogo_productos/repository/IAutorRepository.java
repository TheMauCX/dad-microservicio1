package pe.edu.upeu.ms_catalogo_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.ms_catalogo_productos.domain.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long>{
}

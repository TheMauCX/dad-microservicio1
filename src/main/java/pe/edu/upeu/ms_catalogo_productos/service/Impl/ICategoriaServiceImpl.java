package pe.edu.upeu.ms_catalogo_productos.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_catalogo_productos.domain.Categoria;
import pe.edu.upeu.ms_catalogo_productos.repository.ICategoriaRepository;
import pe.edu.upeu.ms_catalogo_productos.service.ICategoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class ICategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaDao;
    @Override
    public Categoria create(Categoria c) {
        // TODO Auto-generated method stub
        return categoriaDao.save(c);
    }

    @Override
    public Categoria update(Categoria c) {
        // TODO Auto-generated method stub
        return categoriaDao.save(c);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        categoriaDao.deleteById(id);
    }

    @Override
    public Optional<Categoria> read(Long id) {
        // TODO Auto-generated method stub
        return categoriaDao.findById(id);
    }

    @Override
    public List<Categoria> readAll() {
        // TODO Auto-generated method stub
        return categoriaDao.findAll();
    }
}

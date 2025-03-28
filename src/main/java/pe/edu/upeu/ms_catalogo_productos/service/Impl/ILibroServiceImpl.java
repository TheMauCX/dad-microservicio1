package pe.edu.upeu.ms_catalogo_productos.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_catalogo_productos.domain.Libro;
import pe.edu.upeu.ms_catalogo_productos.repository.ILibroRepository;
import pe.edu.upeu.ms_catalogo_productos.service.ILibroService;

import java.util.List;
import java.util.Optional;

@Service
public class ILibroServiceImpl implements ILibroService {

    @Autowired
    private ILibroRepository libroDao;
    @Override
    public Libro create(Libro c) {
        // TODO Auto-generated method stub
        return libroDao.save(c);
    }

    @Override
    public Libro update(Libro c) {
        // TODO Auto-generated method stub
        return libroDao.save(c);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        libroDao.deleteById(id);
    }

    @Override
    public Optional<Libro> read(Long id) {
        // TODO Auto-generated method stub
        return libroDao.findById(id);
    }

    @Override
    public List<Libro> readAll() {
        // TODO Auto-generated method stub
        return libroDao.findAll();
    }
}

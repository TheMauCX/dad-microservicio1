package pe.edu.upeu.ms_catalogo_productos.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_catalogo_productos.domain.Autor;
import pe.edu.upeu.ms_catalogo_productos.repository.IAutorRepository;
import pe.edu.upeu.ms_catalogo_productos.service.IAutorService;

import java.util.List;
import java.util.Optional;

@Service
public class IAutorServiceImpl implements IAutorService {

    @Autowired
    private IAutorRepository autorDao;
    @Override
    public Autor create(Autor c) {
        // TODO Auto-generated method stub
        return autorDao.save(c);
    }

    @Override
    public Autor update(Autor c) {
        // TODO Auto-generated method stub
        return autorDao.save(c);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        autorDao.deleteById(id);
    }

    @Override
    public Optional<Autor> read(Long id) {
        // TODO Auto-generated method stub
        return autorDao.findById(id);
    }

    @Override
    public List<Autor> readAll() {
        // TODO Auto-generated method stub
        return autorDao.findAll();
    }
}

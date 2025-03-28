package pe.edu.upeu.ms_catalogo_productos.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_catalogo_productos.domain.Editorial;
import pe.edu.upeu.ms_catalogo_productos.repository.IEditorialRepository;
import pe.edu.upeu.ms_catalogo_productos.service.IEditorialService;

import java.util.List;
import java.util.Optional;

@Service
public class IEditorialServiceImpl implements IEditorialService {

    @Autowired
    private IEditorialRepository editorialDao;
    @Override
    public Editorial create(Editorial c) {
        // TODO Auto-generated method stub
        return editorialDao.save(c);
    }

    @Override
    public Editorial update(Editorial c) {
        // TODO Auto-generated method stub
        return editorialDao.save(c);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        editorialDao.deleteById(id);
    }

    @Override
    public Optional<Editorial> read(Long id) {
        // TODO Auto-generated method stub
        return editorialDao.findById(id);
    }

    @Override
    public List<Editorial> readAll() {
        // TODO Auto-generated method stub
        return editorialDao.findAll();
    }
}

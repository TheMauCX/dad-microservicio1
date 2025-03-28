package pe.edu.upeu.ms_catalogo_productos.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_catalogo_productos.domain.Autor;
import pe.edu.upeu.ms_catalogo_productos.service.IAutorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private IAutorService iAutorService;

    @GetMapping
    public ResponseEntity<List<Autor>> readAll(){
        try {
            List<Autor> autores = iAutorService.readAll();
            if(autores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Autor> crear(@Valid @RequestBody Autor cat){
        try {
            Autor c = iAutorService.create(cat);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorId(@PathVariable("id") Long id){
        try {
            Autor c = iAutorService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> delAutor(@PathVariable("id") Long id){
        try {
            iAutorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutor(@PathVariable("id") Long id, @Valid @RequestBody Autor cat){

        Optional<Autor> c = iAutorService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(iAutorService.update(cat), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}

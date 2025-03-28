package pe.edu.upeu.ms_catalogo_productos.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_catalogo_productos.domain.Editorial;
import pe.edu.upeu.ms_catalogo_productos.service.IEditorialService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editoriales")
public class CategoriaController {
    @Autowired
    private IEditorialService iEditorialService;

    @GetMapping
    public ResponseEntity<List<Editorial>> readAll(){
        try {
            List<Editorial> editoriales = iEditorialService.readAll();
            if(editoriales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(editoriales, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Editorial> crear(@Valid @RequestBody Editorial cat){
        try {
            Editorial c = iEditorialService.create(cat);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Editorial> getEditorialId(@PathVariable("id") Long id){
        try {
            Editorial c = iEditorialService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Editorial> delEditorial(@PathVariable("id") Long id){
        try {
            iEditorialService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable("id") Long id, @Valid @RequestBody Editorial cat){

        Optional<Editorial> c = iEditorialService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(iEditorialService.update(cat), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}

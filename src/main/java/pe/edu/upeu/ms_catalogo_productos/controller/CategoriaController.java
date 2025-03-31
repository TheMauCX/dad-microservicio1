package pe.edu.upeu.ms_catalogo_productos.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_catalogo_productos.domain.Categoria;
import pe.edu.upeu.ms_catalogo_productos.service.ICategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService iCategoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> readAll(){
        try {
            List<Categoria> categorias = iCategoriaService.readAll();
            if(categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria cat){
        try {
            Categoria c = iCategoriaService.create(cat);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaId(@PathVariable("id") Long id){
        try {
            Categoria c = iCategoriaService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> delCategoria(@PathVariable("id") Long id){
        try {
            iCategoriaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable("id") Long id, @Valid @RequestBody Categoria cat){

        Optional<Categoria> c = iCategoriaService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(iCategoriaService.update(cat), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}

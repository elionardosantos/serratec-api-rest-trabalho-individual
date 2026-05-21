package org.serratec.curso.controller;

import java.net.URI;
import java.util.List;

import org.serratec.curso.dto.CursoDTORequest;
import org.serratec.curso.dto.CursoDTOResponse;
import org.serratec.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTOResponse>> listar() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CursoDTOResponse> save(@Valid @RequestBody CursoDTORequest curso) {

        CursoDTOResponse cursoDTO = cursoService.save(curso);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(cursoDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(cursoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTOResponse> update(@PathVariable Long id, @Valid @RequestBody CursoDTORequest curso) {
        return ResponseEntity.ok(cursoService.update(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

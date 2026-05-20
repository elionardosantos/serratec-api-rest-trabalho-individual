package org.serratec.curso.controller;

import java.net.URI;
import java.util.List;

import org.serratec.curso.dto.AlunoDTORequest;
import org.serratec.curso.dto.AlunoDTOResponse;
import org.serratec.curso.service.AlunoService;
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
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTOResponse>> listar() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDTOResponse> save(@Valid @RequestBody AlunoDTORequest aluno) {

            AlunoDTOResponse alunoDTO = alunoService.save(aluno);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(alunoDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(alunoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> update(@PathVariable Long id, @Valid @RequestBody AlunoDTORequest aluno) {
        return ResponseEntity.ok(alunoService.update(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

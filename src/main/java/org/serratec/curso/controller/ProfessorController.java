package org.serratec.curso.controller;

import java.net.URI;
import java.util.List;

import org.serratec.curso.dto.ProfessorDTORequest;
import org.serratec.curso.dto.ProfessorDTOResponse;
import org.serratec.curso.service.ProfessorService;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professores")
public class ProfessorController {


    @Autowired
    private ProfessorService professorService;

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Lista de professores retornada com sucesso")
    @Operation(summary = "Listar todos os professores", description = "Retorna uma lista de todos os professores cadastrados no sistema.")
    public ResponseEntity<List<ProfessorDTOResponse>> listar() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Professor encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    @Operation(summary = "Buscar professor por ID", description = "Retorna os dados de um professor específico com base no ID fornecido.")
    public ResponseEntity<ProfessorDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Professor criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @Operation(summary = "Criar novo professor", description = "Cria um novo professor no sistema.")
    public ResponseEntity<ProfessorDTOResponse> save(@RequestBody @Valid ProfessorDTORequest professor) {

            ProfessorDTOResponse professorDTO = professorService.save(professor);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(professorDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(professorDTO);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    @Operation(summary = "Atualizar professor", description = "Atualiza os dados de um professor específico com base no ID fornecido.")
    public ResponseEntity<ProfessorDTOResponse> update(@PathVariable Long id, @Valid @RequestBody ProfessorDTORequest professor) {
        return ResponseEntity.ok(professorService.update(id, professor));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Professor excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    @Operation(summary = "Excluir professor", description = "Exclui um professor específico com base no ID fornecido.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

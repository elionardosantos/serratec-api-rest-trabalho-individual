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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Operation(summary = "Listar todos os cursos", description = "Retorna uma lista de todos os cursos cadastrados no sistema.")
    public ResponseEntity<List<CursoDTOResponse>> listar() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    @Operation(summary = "Buscar curso por ID", description = "Retorna os dados de um curso específico com base no ID fornecido.")
    public ResponseEntity<CursoDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Curso criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @Operation(summary = "Criar novo curso", description = "Cria um novo curso no sistema.")
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
    @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    @Operation(summary = "Atualizar curso", description = "Atualiza os dados de um curso específico com base no ID fornecido.")
    public ResponseEntity<CursoDTOResponse> update(@PathVariable Long id, @Valid @RequestBody CursoDTORequest curso) {
        return ResponseEntity.ok(cursoService.update(id, curso));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Curso excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    @Operation(summary = "Excluir curso", description = "Exclui um curso específico com base no ID fornecido.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

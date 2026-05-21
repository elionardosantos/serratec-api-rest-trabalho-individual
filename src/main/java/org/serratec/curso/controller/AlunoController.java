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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista de todos os alunos cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
    public ResponseEntity<List<AlunoDTOResponse>> listar() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar aluno por ID", description = "Retorna os dados de um aluno específico com base no ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<AlunoDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo aluno", description = "Cria um novo aluno no sistema.")
    @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<AlunoDTOResponse> save(@RequestBody @Valid AlunoDTORequest aluno) {

            AlunoDTOResponse alunoDTO = alunoService.save(aluno);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(alunoDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(alunoDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno específico com base no ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<AlunoDTOResponse> update(@PathVariable Long id, @Valid @RequestBody AlunoDTORequest aluno) {
        return ResponseEntity.ok(alunoService.update(id, aluno));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir aluno", description = "Exclui um aluno específico com base no ID fornecido.")
    @ApiResponse(responseCode = "204", description = "Aluno excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

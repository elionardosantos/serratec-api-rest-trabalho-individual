package org.serratec.curso.controller;

import java.net.URI;
import java.util.List;

import org.serratec.curso.dto.PerfilSocialDTORequest;
import org.serratec.curso.dto.PerfilSocialDTOResponse;
import org.serratec.curso.service.PerfilSocialService;
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
@RequestMapping("/perfis")
public class PerfilSocialController {

    @Autowired
    private PerfilSocialService perfilSocialService;

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Lista de perfis sociais retornada com sucesso")
    @Operation(summary = "Listar todos os perfis sociais", description = "Retorna uma lista de todos os perfis sociais cadastrados no sistema.")
    public ResponseEntity<List<PerfilSocialDTOResponse>> findAll() {
        return ResponseEntity.ok(perfilSocialService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Perfil social encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Perfil social não encontrado")
    @Operation(summary = "Buscar perfil social por ID", description = "Retorna os dados de um perfil social específico com base no ID fornecido.")
    public ResponseEntity<PerfilSocialDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(perfilSocialService.findById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Perfil social criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @Operation(summary = "Criar novo perfil social", description = "Cria um novo perfil social no sistema.")
    public ResponseEntity<PerfilSocialDTOResponse> save(@Valid @RequestBody PerfilSocialDTORequest perfilSocial) {
        
        PerfilSocialDTOResponse perfilSocialDTO = perfilSocialService.save(perfilSocial);
        
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(perfilSocialDTO.getId())
            .toUri();

        return ResponseEntity.created(uri).body(perfilSocialDTO);   
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Perfil social atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Perfil social não encontrado")
    @Operation(summary = "Atualizar perfil social", description = "Atualiza os dados de um perfil social específico com base no ID fornecido.")
    public ResponseEntity<PerfilSocialDTOResponse> update(@PathVariable Long id, @Valid @RequestBody PerfilSocialDTORequest perfilSocial) {
        return ResponseEntity.ok(perfilSocialService.update(id, perfilSocial));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Perfil social excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Perfil social não encontrado")
    @Operation(summary = "Excluir perfil social", description = "Exclui um perfil social específico com base no ID fornecido.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perfilSocialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

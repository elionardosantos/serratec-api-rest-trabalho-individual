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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfis")
public class PerfilSocialController {

    @Autowired
    private PerfilSocialService perfilSocialService;

    @GetMapping
    public ResponseEntity<List<PerfilSocialDTOResponse>> findAll() {
        return ResponseEntity.ok(perfilSocialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilSocialDTOResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(perfilSocialService.findById(id));
    }

    @PostMapping
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
    public ResponseEntity<PerfilSocialDTOResponse> update(@PathVariable Long id, @Valid @RequestBody PerfilSocialDTORequest perfilSocial) {
        return ResponseEntity.ok(perfilSocialService.update(id, perfilSocial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perfilSocialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

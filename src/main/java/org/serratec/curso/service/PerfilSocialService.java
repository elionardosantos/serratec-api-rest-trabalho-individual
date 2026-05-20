package org.serratec.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.curso.domain.PerfilSocial;
import org.serratec.curso.dto.PerfilSocialDTORequest;
import org.serratec.curso.dto.PerfilSocialDTOResponse;
import org.serratec.curso.repository.PerfilSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PerfilSocialService {

    @Autowired
    private PerfilSocialRepository perfilSocialRepository;

    public List<PerfilSocialDTOResponse> findAll() {

        List<PerfilSocial> perfis = perfilSocialRepository.findAll();
        List<PerfilSocialDTOResponse> perfisDTO = new ArrayList<PerfilSocialDTOResponse>();

        for(PerfilSocial perfil : perfis) {
            perfisDTO.add(new PerfilSocialDTOResponse(perfil));
        }

        return perfisDTO;
    }

    public PerfilSocialDTOResponse findById(Long id) {
        
        Optional<PerfilSocial> perfil = perfilSocialRepository.findById(id);
        PerfilSocialDTOResponse perfilDTO = new PerfilSocialDTOResponse(perfil.get());

        return perfilDTO;
    }

    @Transactional
    public PerfilSocialDTOResponse save(PerfilSocialDTORequest perfilSocialDTORequest) {

        PerfilSocial perfilSocial = new PerfilSocial(perfilSocialDTORequest);
        PerfilSocial perfilSocialResponse = perfilSocialRepository.save(perfilSocial);
    
        return perfilSocialResponse.toDTO();
    }

    @Transactional
    public PerfilSocialDTOResponse update(Long id, PerfilSocialDTORequest perfilSocialDTORequest) {
        
        PerfilSocial perfilSocial = new PerfilSocial(perfilSocialDTORequest);
        Optional<PerfilSocial> perfilSocialDTO = perfilSocialRepository.findById(id);

        if (perfilSocialDTO.isPresent()) {

            perfilSocial.setId(perfilSocialDTO.get().getId());
            PerfilSocial perfilSocialResponse = perfilSocialRepository.save(perfilSocial);

            return perfilSocialResponse.toDTO();
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        perfilSocialRepository.deleteById(id);
    }

}
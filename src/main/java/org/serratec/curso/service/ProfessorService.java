package org.serratec.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.curso.domain.Professor;
import org.serratec.curso.dto.ProfessorDTORequest;
import org.serratec.curso.dto.ProfessorDTOResponse;
import org.serratec.curso.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
        public List<ProfessorDTOResponse> findAll() {
        
        List<Professor> professors = professorRepository.findAll();
        List<ProfessorDTOResponse> professorsDTO = new ArrayList<ProfessorDTOResponse>();

        for(Professor professor : professors) {
            professorsDTO.add(new ProfessorDTOResponse(professor));
        }

        return professorsDTO;
    }
    
    public ProfessorDTOResponse findById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        
        ProfessorDTOResponse professorDTO = new ProfessorDTOResponse();

        professorDTO.setId(professor.get().getId());
        professorDTO.setNome(professor.get().getNome());
        professorDTO.setEmail(professor.get().getEmail());
        professorDTO.setSenha(professor.get().getSenha());

        return professorDTO;
    }

    @Transactional
    public ProfessorDTOResponse save(ProfessorDTORequest professorDTORequest) {
        
        Professor professor = new Professor(professorDTORequest);
        Professor professorResponse = professorRepository.save(professor);
        
        return professorResponse.toDTO();
    }

    @Transactional
    public ProfessorDTOResponse update(Long id, ProfessorDTORequest professorDTORequest) {
        
        Professor professor = new Professor(professorDTORequest);
        Optional<Professor> professorDTO = professorRepository.findById(id);

        if(professorDTO.isPresent()) {
            
            professor.setId(professorDTO.get().getId());
            Professor professorResponse = professorRepository.save(professor);
            
            return professorResponse.toDTO();
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
    
}

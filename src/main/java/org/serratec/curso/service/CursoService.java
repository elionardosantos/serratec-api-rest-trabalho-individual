package org.serratec.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.curso.domain.Curso;
import org.serratec.curso.dto.CursoDTORequest;
import org.serratec.curso.dto.CursoDTOResponse;
import org.serratec.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTOResponse> findAll() {
        
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoDTOResponse> cursosDTO = new ArrayList<CursoDTOResponse>();

        for(Curso curso : cursos) {
            cursosDTO.add(new CursoDTOResponse(curso));
        }

        return cursosDTO;
    }
    
    public CursoDTOResponse findById(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.get().toDTO();
    }

    @Transactional
    public CursoDTOResponse save(CursoDTORequest cursoDTORequest) {
        
        Curso curso = new Curso(cursoDTORequest);
        Curso cursoResponse = cursoRepository.save(curso);
        
        return cursoResponse.toDTO();
    }

    @Transactional
    public CursoDTOResponse update(Long id, CursoDTORequest cursoDTORequest) {
        
        Curso curso = new Curso(cursoDTORequest);
        Optional<Curso> cursoDTO = cursoRepository.findById(id);

        if(cursoDTO.isPresent()) {
            
            curso.setId(cursoDTO.get().getId());
            Curso cursoResponse = cursoRepository.save(curso);
            
            return cursoResponse.toDTO();
        }
        return null;
        
    }

    @Transactional
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}


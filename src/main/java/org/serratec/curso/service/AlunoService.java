package org.serratec.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.dto.AlunoDTORequest;
import org.serratec.curso.dto.AlunoDTOResponse;
import org.serratec.curso.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTOResponse> findAll() {
        
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoDTOResponse> alunosDTO = new ArrayList<AlunoDTOResponse>();

        for(Aluno aluno : alunos) {
            alunosDTO.add(new AlunoDTOResponse(aluno));
        }

        return alunosDTO;
    }
    
    public AlunoDTOResponse findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        
        AlunoDTOResponse alunoDTO = new AlunoDTOResponse();

        alunoDTO.setId(aluno.get().getId());
        alunoDTO.setNome(aluno.get().getNome());
        alunoDTO.setEmail(aluno.get().getEmail());
        alunoDTO.setDataNascimento(aluno.get().getDataNascimento());
        alunoDTO.setPerfilSocial(aluno.get().getPerfilSocial());

        return alunoDTO;
    }

    @Transactional
    public AlunoDTOResponse save(AlunoDTORequest alunoDTORequest) {
        
        Aluno aluno = new Aluno(alunoDTORequest);
        Aluno alunoResponse = alunoRepository.save(aluno);
        
        return alunoResponse.toDTO();
    }

    @Transactional
    public AlunoDTOResponse update(Long id, AlunoDTORequest alunoDTORequest) {
        
        Aluno aluno = new Aluno(alunoDTORequest);
        Optional<Aluno> alunoDTO = alunoRepository.findById(id);

        if(alunoDTO.isPresent()) {
            
            aluno.setId(alunoDTO.get().getId());
            Aluno alunoResponse = alunoRepository.save(aluno);
            
            return alunoResponse.toDTO();
        }
        return null;
    }

    @Transactional
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

}

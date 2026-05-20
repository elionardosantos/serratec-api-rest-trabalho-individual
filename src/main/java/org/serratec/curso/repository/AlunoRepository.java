package org.serratec.curso.repository;

import org.serratec.curso.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    Aluno findByEmail(String email);

}

package org.serratec.curso.dto;

import java.util.List;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.Curso;

public class CursoDTOResponse {

    private Long id;
    private String titulo;
    private List<Aluno> alunos;

    public CursoDTOResponse() {
    }

    public CursoDTOResponse(Curso curso) {
        this.id = curso.getId();
        this.titulo = curso.getTitulo();
        this.alunos = curso.getAlunos();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    
}

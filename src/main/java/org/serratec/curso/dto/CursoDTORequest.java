package org.serratec.curso.dto;

import java.util.List;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.Professor;

import io.swagger.v3.oas.annotations.media.Schema;

public class CursoDTORequest {

    @Schema(description = "Título do curso", example = "Java Fundamentals")
    private String titulo;

    @Schema(description = "Alunos matriculados no curso", example = "[{\"id\": 1, \"nome\": \"João Silva\"}]")
    private List<Aluno> alunos;

    @Schema(description = "Professor do curso", example = "{\"id\": 1, \"nome\": \"Prof. Maria\"}")
    private Professor professor;
    
    public CursoDTORequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}


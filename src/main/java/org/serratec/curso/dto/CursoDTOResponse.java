package org.serratec.curso.dto;

import java.util.List;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.Curso;
import org.serratec.curso.domain.Professor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({
    "id",
    "titulo",
    "professor",
    "alunos"
})
public class CursoDTOResponse {

    @Schema(description = "ID único gerado no banco de dados", example = "42")
    private Long id;
    @Schema(description = "Título do curso", example = "Java Fundamentals")
    private String titulo;
    @Schema(description = "Alunos matriculados no curso", example = "[{\"id\": 1, \"nome\": \"João Silva\"}]")
    private List<Aluno> alunos;
    @Schema(description = "Professor do curso", example = "{\"id\": 1, \"nome\": \"Prof. Maria\"}")
    private Professor professor;

    public CursoDTOResponse() {
    }

    public CursoDTOResponse(Curso curso) {
        this.id = curso.getId();
        this.titulo = curso.getTitulo();
        this.alunos = curso.getAlunos();
        this.professor = curso.getProfessor();
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    
}

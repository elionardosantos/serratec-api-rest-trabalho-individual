package org.serratec.curso.dto;

import java.util.List;

import org.serratec.curso.domain.Aluno;

public class CursoDTORequest {

    private String titulo;
    private List<Aluno> alunos;
    
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
    

}


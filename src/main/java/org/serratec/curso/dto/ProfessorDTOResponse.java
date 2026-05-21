package org.serratec.curso.dto;

import org.serratec.curso.domain.Professor;

public class ProfessorDTOResponse {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    
    public ProfessorDTOResponse() {
    }
    public ProfessorDTOResponse(Professor professor) {

        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.senha = professor.getSenha();

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}

package org.serratec.curso.dto;

import org.serratec.curso.domain.Professor;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProfessorDTOResponse {

    @Schema(description = "ID único gerado no banco de dados", example = "42")
    private Long id;
    @Schema(description = "Nome do professor", example = "Dr. João da Silva")
    private String nome;
    @Schema(description = "Email do professor", example = "joao.silva@university.edu")
    private String email;
    @Schema(description = "Senha do professor", example = "senha123")
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

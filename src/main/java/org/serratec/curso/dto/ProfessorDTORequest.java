package org.serratec.curso.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProfessorDTORequest {

    @Schema(description = "Nome do professor", example = "Dr. João da Silva")
    private String nome;
    @Schema(description = "Email do professor", example = "joao.silva@university.edu")
    private String email;
    @Schema(description = "Senha do professor", example = "senha123")
    private String senha;
    
    public ProfessorDTORequest() {
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

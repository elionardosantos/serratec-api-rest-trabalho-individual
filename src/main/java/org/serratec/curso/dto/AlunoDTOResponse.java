package org.serratec.curso.dto;

import java.time.LocalDate;

import org.serratec.curso.domain.Aluno;

public class AlunoDTOResponse {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    
    public AlunoDTOResponse() {
    }
    
    public AlunoDTOResponse(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.dataNascimento = aluno.getDataNascimento();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}

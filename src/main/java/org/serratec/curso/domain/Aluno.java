package org.serratec.curso.domain;

import java.time.LocalDate;

import org.serratec.curso.dto.AlunoDTORequest;
import org.serratec.curso.dto.AlunoDTOResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 120)
    private String nome;

    @Email
    private String email;

    private String senha;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Aluno() {
    }

    public Aluno(Long id, @Size(max = 120) String nome, @Email String email, String senha, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Aluno(AlunoDTORequest alunoDTORequest) {
        this.nome = alunoDTORequest.getNome();
        this.email = alunoDTORequest.getEmail();
        this.senha = alunoDTORequest.getSenha();
        this.dataNascimento = alunoDTORequest.getDataNascimento();
    }

    public AlunoDTOResponse toDTO() {
        AlunoDTOResponse alunoDTO = new AlunoDTOResponse();
        alunoDTO.setId(this.id);
        alunoDTO.setNome(this.nome);
        alunoDTO.setEmail(this.email);
        alunoDTO.setDataNascimento(this.dataNascimento);
        return alunoDTO;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}

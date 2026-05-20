package org.serratec.curso.dto;

import java.time.LocalDate;

import org.serratec.curso.domain.PerfilSocial;

public class AlunoDTORequest {

    private Long id;
    private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
    private LocalDate dataNascimento;
    private PerfilSocial perfilSocial;
    
    public AlunoDTORequest() {
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilSocial getPerfilSocial() {
        return perfilSocial;
    }

    public void setPerfilSocial(PerfilSocial perfilSocial) {
        this.perfilSocial = perfilSocial;
    }

}

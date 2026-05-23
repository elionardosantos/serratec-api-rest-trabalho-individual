package org.serratec.curso.dto;

import java.time.LocalDate;
import java.util.List;

import org.serratec.curso.domain.Curso;
import org.serratec.curso.domain.PerfilSocial;

import io.swagger.v3.oas.annotations.media.Schema;

public class AlunoDTORequest {

    @Schema(description = "Nome completo do usuário", example = "João Silva")
    private String nome;
    
    @Schema(description = "Email válido do usuário", example = "joao.silva@example.com")
	private String email;

    @Schema(description = "Senha do usuário", example = "senha123")
	private String senha;

	@Schema(description = "Confirmação da senha", example = "senha123")
	private String confirmaSenha;

    @Schema(description = "Data de nascimento do usuário", example = "1990-01-01")
    private LocalDate dataNascimento;

    @Schema(description = "Perfil social do usuário", example = "{\"renda\": 5000.00, \"escolaridade\": \"Ensino Superior Completo\"}")
    private PerfilSocial perfilSocial;
    
    @Schema(description = "Cursos matriculados", example = "[{\"id\": 1, \"nome\": \"Java Fundamentals\"}]")
    private List<Curso> cursos;
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

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
    
    public PerfilSocial getPerfilSocial() {
        return perfilSocial;
    }

    public void setPerfilSocial(PerfilSocial perfilSocial) {
        this.perfilSocial = perfilSocial;
    }

}

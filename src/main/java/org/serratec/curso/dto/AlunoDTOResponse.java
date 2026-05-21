package org.serratec.curso.dto;

import java.time.LocalDate;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.PerfilSocial;

import io.swagger.v3.oas.annotations.media.Schema;

public class AlunoDTOResponse {

    @Schema(description = "ID único gerado no banco de dados", example = "42")
    private Long id;

    @Schema(description = "Nome completo do usuário", example = "João Silva")
    private String nome;

    @Schema(description = "Email válido do usuário", example = "joao.silva@example.com")
    private String email;

    @Schema(description = "Data de nascimento do usuário", example = "1990-01-01")
    private LocalDate dataNascimento;

    @Schema(description = "Perfil social do usuário", example = "{\"renda\": 5000.00, \"escolaridade\": \"Ensino Superior Completo\"}")
    private PerfilSocial perfilSocial;
    
    public AlunoDTOResponse() {
    }
    
    public AlunoDTOResponse(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.dataNascimento = aluno.getDataNascimento();
        this.perfilSocial = aluno.getPerfilSocial();
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

    public PerfilSocial getPerfilSocial() {
        return perfilSocial;
    }

    public void setPerfilSocial(PerfilSocial perfilSocial) {
        this.perfilSocial = perfilSocial;
    }
    
}

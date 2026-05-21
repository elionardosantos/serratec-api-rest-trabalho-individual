package org.serratec.curso.dto;

import java.math.BigDecimal;

import org.serratec.curso.domain.Aluno;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilSocialDTORequest {

    @Schema(description = "ID único gerado no banco de dados", example = "42")
    private Long id;
    @Schema(description = "Renda do aluno", example = "2000.00")
    private BigDecimal renda;
    @Schema(description = "Escolaridade do aluno", example = "Ensino Superior Completo")
    private String escolaridade;
    @Schema(description = "Aluno associado ao perfil social", example = "{\"id\": 1, \"nome\": \"João Silva\"}")
    private Aluno aluno;
    
    public PerfilSocialDTORequest() {
    }

    public PerfilSocialDTORequest(PerfilSocialDTORequest perfil) {
        this.id = perfil.getId();
        this.renda = perfil.getRenda();
        this.escolaridade = perfil.getEscolaridade();
        this.aluno = perfil.getAluno();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}

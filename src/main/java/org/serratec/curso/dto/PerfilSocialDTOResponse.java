package org.serratec.curso.dto;

import java.math.BigDecimal;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.PerfilSocial;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilSocialDTOResponse {

    @Schema(description = "ID único gerado no banco de dados", example = "42")
    private Long id;
    @Schema(description = "Escolaridade do aluno", example = "Ensino Superior Completo")
    private String escolaridade;
    @Schema(description = "Renda do aluno", example = "2000.00")
    private BigDecimal renda;
    @Schema(description = "Aluno associado ao perfil social", example = "{\"id\": 1, \"nome\": \"João Silva\"}")
    private Aluno aluno;

    public PerfilSocialDTOResponse() {
    }

    public PerfilSocialDTOResponse(PerfilSocial perfilSocial) {
        this.id = perfilSocial.getId();
        this.escolaridade = perfilSocial.getEscolaridade();
        this.renda = perfilSocial.getRenda();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    
}

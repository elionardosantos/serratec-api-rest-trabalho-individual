package org.serratec.curso.dto;

import java.math.BigDecimal;

import org.serratec.curso.domain.Aluno;
import org.serratec.curso.domain.PerfilSocial;

public class PerfilSocialDTOResponse {

    private Long id;
    private String escolaridade;
    private BigDecimal renda;
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

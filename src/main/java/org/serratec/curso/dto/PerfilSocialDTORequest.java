package org.serratec.curso.dto;

import java.math.BigDecimal;

import org.serratec.curso.domain.Aluno;

public class PerfilSocialDTORequest {

    private Long id;
    private BigDecimal renda;
    private String escolaridade;
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

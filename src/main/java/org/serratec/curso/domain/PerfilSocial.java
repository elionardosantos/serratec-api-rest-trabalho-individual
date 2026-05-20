package org.serratec.curso.domain;

import java.math.BigDecimal;

import org.serratec.curso.dto.PerfilSocialDTORequest;
import org.serratec.curso.dto.PerfilSocialDTOResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "perfil_social")
public class PerfilSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "0")
    private BigDecimal renda;

    private String escolaridade;

    @OneToOne(mappedBy = "perfilSocial", fetch = FetchType.LAZY)
    private Aluno aluno;

    public PerfilSocial() {
    }

    public PerfilSocial(PerfilSocialDTORequest perfilSocialDTORequest) {
        this.id = perfilSocialDTORequest.getId();
        this.renda = perfilSocialDTORequest.getRenda();
        this.escolaridade = perfilSocialDTORequest.getEscolaridade();
    }

    public PerfilSocialDTOResponse toDTO() {

        PerfilSocialDTOResponse perfilSocialDTO = new PerfilSocialDTOResponse();
        perfilSocialDTO.setId(this.id);
        perfilSocialDTO.setRenda(this.renda);
        perfilSocialDTO.setEscolaridade(this.escolaridade);

        return perfilSocialDTO;
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

}

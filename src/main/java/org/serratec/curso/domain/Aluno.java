package org.serratec.curso.domain;

import java.time.LocalDate;
import java.util.List;

import org.serratec.curso.dto.AlunoDTORequest;
import org.serratec.curso.dto.AlunoDTOResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 120)
    @NotBlank(message = "O nome do aluno é obrigatório")
    private String nome;

    @Email(message = "Um email válido é obrigatório")
    private String email;

    private String senha;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_perfil_social")
    private PerfilSocial perfilSocial;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnore
    private List<Curso> cursos;

    public Aluno() {
    }

    public Aluno(AlunoDTORequest alunoDTORequest) {
        this.nome = alunoDTORequest.getNome();
        this.email = alunoDTORequest.getEmail();
        this.senha = alunoDTORequest.getSenha();
        this.dataNascimento = alunoDTORequest.getDataNascimento();
        this.perfilSocial = alunoDTORequest.getPerfilSocial();
    }

    public Aluno(AlunoDTOResponse alunoDTOResponse) {
        this.nome = alunoDTOResponse.getNome();
        this.email = alunoDTOResponse.getEmail();
        this.dataNascimento = alunoDTOResponse.getDataNascimento();
        this.perfilSocial = alunoDTOResponse.getPerfilSocial();
    }

    public AlunoDTOResponse toDTO() {
        AlunoDTOResponse alunoDTO = new AlunoDTOResponse();
        alunoDTO.setId(this.id);
        alunoDTO.setNome(this.nome);
        alunoDTO.setEmail(this.email);
        alunoDTO.setDataNascimento(this.dataNascimento);
        alunoDTO.setPerfilSocial(this.perfilSocial);
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

    public PerfilSocial getPerfilSocial() {
        return perfilSocial;
    }

    public void setPerfilSocial(PerfilSocial perfilSocial) {
        this.perfilSocial = perfilSocial;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }


    
}

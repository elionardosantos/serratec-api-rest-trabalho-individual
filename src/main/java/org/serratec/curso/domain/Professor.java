package org.serratec.curso.domain;

import java.util.List;

import org.serratec.curso.dto.ProfessorDTORequest;
import org.serratec.curso.dto.ProfessorDTOResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "Tamanho máximo de 255 caracteres excedido")
    @NotBlank(message = "O nome do professor é obrigatório")
    private String nome;

    @Email(message = "O email precisa ser válido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank
    private String senha;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;

    public Professor() {
    }

    public Professor(ProfessorDTORequest professorDTO){
        this.nome = professorDTO.getNome();
        this.email = professorDTO.getEmail();
        this.senha = professorDTO.getSenha();
    }

    public ProfessorDTOResponse toDTO() {
        return new ProfessorDTOResponse(this);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    
}

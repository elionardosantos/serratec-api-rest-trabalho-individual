package org.serratec.curso.domain;

import java.util.List;

import org.serratec.curso.dto.CursoDTORequest;
import org.serratec.curso.dto.CursoDTOResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 120, message = "O título excedeu o tamanho máximo de 120 caracteres")
    @NotBlank(message = "O título do curso é obrigatório")
    private String titulo;

    @ManyToMany
    @JoinTable(
        name = "matricula_aluno_curso",
        joinColumns = @JoinColumn(name="id_curso"),
        inverseJoinColumns = @JoinColumn(name="id_aluno")
    )
    private List<Aluno> alunos;

    public Curso() {
    }

    public Curso (CursoDTORequest cursoDTORequest) {
        this.titulo = cursoDTORequest.getTitulo();
        this.alunos = cursoDTORequest.getAlunos();
    }


    public CursoDTOResponse toDTO() {
        CursoDTOResponse cursoDTO = new CursoDTOResponse();

        cursoDTO.setId(this.getId());
        cursoDTO.setTitulo(this.getTitulo());

        return cursoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    

}

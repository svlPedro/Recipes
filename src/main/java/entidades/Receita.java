package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Enums.Categoria;
import Enums.Origem;

@Entity
public class Receita {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100) 
    private String nome;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private Origem origem;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Ingredientes> ingredientes;

    @Column(columnDefinition = "TEXT") 
    private String modoDePreparo;

    @Column(nullable = false)
    private Integer tempoDePreparo; 

    @Column(nullable = false)
    private int qtdAvaliacoes;

    @Column(nullable = false)
    private int nota;

	public Receita(String nome, Categoria categoria, Origem origem, List<Ingredientes> ingredientes,
			String modoDePreparo, Integer tempoDePreparo, int qtdAvaliacoes, int nota) {
		this.nome = nome;
		this.categoria = categoria;
		this.origem = origem;
		this.ingredientes = ingredientes;
		this.modoDePreparo = modoDePreparo;
		this.tempoDePreparo = tempoDePreparo;
		this.qtdAvaliacoes = qtdAvaliacoes;
		this.nota = nota;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public int getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(int qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}   				
	
	public void avaliar(int avaliacao) {
		nota += avaliacao;
		qtdAvaliacoes++;		
	}
}
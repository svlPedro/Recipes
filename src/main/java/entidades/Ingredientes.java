package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity			
public class Ingredientes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(nullable = false, length = 100) 
    private String nome;

    @Column(nullable = false) 
    private Integer quantidade;

    @Column(nullable = false, length = 50) 
    private String unidade;

    @ManyToOne
    @JoinColumn(name = "receita_id", nullable = false) 	
    private Receita receita;

	public Ingredientes(String nome, Integer quantidade, String unidade, Receita receita) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.receita = receita;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}    
}

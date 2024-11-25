package bean;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.AlunoDao;
import entidades.Aluno;

@ManagedBean
public class AlunoBean {
	private Aluno aluno = new Aluno();
	private List<Aluno> lista;
	private Aluno alunoSelecionado;
	
	public String salvar() {
		AlunoDao.salvar(aluno);
		aluno = new Aluno();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno cadastrado com Sucesso!"));
		return null;
	}
	
	public String deletar() {
	    lista.remove(alunoSelecionado);
	    AlunoDao.deletar(alunoSelecionado);
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno removido com sucesso!"));
	    return null;
	}
	
    public String info() {
    	if(alunoSelecionado == null){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há nenhum aluno Selecionado."));
    		return null;
    	}else {
    	StringBuilder sb = new StringBuilder();
    	sb.append("(Id: ").append(alunoSelecionado.getId()).append(" | ");
    	sb.append("Nome: ").append(alunoSelecionado.getNome()).append(" | ");
    	sb.append("Matrícula: ").append(alunoSelecionado.getMatricula()).append(" | ");
    	sb.append("Curso: ").append(alunoSelecionado.getCurso()).append(" | ");
    	sb.append("Semestres Restantes: ").append(alunoSelecionado.semestresRestantes()).append(" | ");
    	sb.append("Data de Nascimento: ").append(alunoSelecionado.getDataFormatada()).append(")");
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalhes do aluno Selecionado "+sb.toString()));
    	return null;
    	}
    }
	
	public String size() {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alunos Cadastrados: "+lista.size()));
	    return null;
	}
	
	public String paginaInicial() {
		this.aluno = new Aluno();
		return "index";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public List<Aluno> getLista() {
		if (lista == null) {
			lista = AlunoDao.listarTodos();
		}
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}
}
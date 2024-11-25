package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Aluno;
import util.JPAUtil;

public class AlunoDao {

	public static void salvar(Aluno aluno) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void deletar(Aluno aluno) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		aluno = em.find(Aluno.class, aluno.getId());
		em.remove(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Aluno> listarTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Aluno a");
		List<Aluno> lista = q.getResultList();
		em.close();
		return lista;
	}

}

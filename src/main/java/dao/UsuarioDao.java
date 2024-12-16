package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Usuario;
import util.JPAUtil;

public class UsuarioDao {
	//cadastro
	public static void salvar(Usuario user) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Usuario> listarTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Aluno a");
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	//exclusivo para admins
	public static void deletar(Usuario user) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		user = em.find(Usuario.class, user.getId());
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
}

package bean;

import javax.faces.bean.ManagedBean;

import dao.UsuarioDao;
import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public String redirect() {
		return "cadastro";
	}
	
	public String salvar() {
		UsuarioDao.salvar(usuario);
		usuario = new Usuario();
		return "index";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

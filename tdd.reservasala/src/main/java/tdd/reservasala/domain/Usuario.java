package tdd.reservasala.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean temPrivilegio;

	private Usuario() {
	}

	private Usuario(boolean temPrivilegio) {
		this.temPrivilegio = temPrivilegio;
	}

	public static Usuario criarUsuarioSimples() {
		return new Usuario(false);
	}

	public static Usuario criarSuperUsuario() {
		return new Usuario(true);
	}

	public boolean temPrivilegio() {
		return temPrivilegio;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Usuario && id == ((Usuario) obj).id;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.intValue();
	}

	@Override
	public String toString() {
		return "Usuario " + id;
	}

}

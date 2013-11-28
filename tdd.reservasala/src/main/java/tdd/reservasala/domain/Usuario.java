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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario " + id;
	}

}

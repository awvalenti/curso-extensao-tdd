package tdd.reservasala.domain;

public class Usuario {

	private final boolean temPrivilegio;

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

}

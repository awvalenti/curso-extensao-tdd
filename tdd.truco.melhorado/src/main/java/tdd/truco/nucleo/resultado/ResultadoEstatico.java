package tdd.truco.nucleo.resultado;

enum ResultadoEstatico implements Resultado {
	EM_ANDAMENTO, EMPATE;

	@Override
	public boolean temVencedor() {
		return false;
	}

}
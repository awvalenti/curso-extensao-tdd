package valenti.aula1.truco.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColecaoCartas {

	private List<Carta> cartas;

	public ColecaoCartas(Carta... cartas) {
		this(new ArrayList<>(Arrays.asList(cartas)));
	}

	public ColecaoCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public void comprarTodasDe(ColecaoCartas... outras) {
		for (ColecaoCartas outra : outras) {
			this.cartas.addAll(outra.cartas);
			outra.cartas.clear();
		}
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}

	public void comprar(int quantidadeCartas, ColecaoCartas outraColecao) {
		List<Carta> cartasAComprar = outraColecao.cartas.subList(0, quantidadeCartas);
		this.cartas.addAll(cartasAComprar);
		cartasAComprar.clear();
	}

	public Carta retirarUma() {
		Carta comprada = cartas.get(0);
		cartas.remove(0);
		return comprada;
	}

	public void acrescentar(Carta carta) {
		cartas.add(carta);
	}

	public Carta retirarCarta(int indiceCarta) {
		return cartas.remove(indiceCarta);
	}

	public ColecaoCartas gerarCopiaImutavel() {
		return new ColecaoCartas(Collections.unmodifiableList(cartas));
	}

	public int getQuantidade() {
		return cartas.size();
	}

	@Override
	public String toString() {
		return cartas.toString();
	}

}

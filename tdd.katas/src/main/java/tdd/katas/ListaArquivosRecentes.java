package tdd.katas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaArquivosRecentes implements Iterable<String> {

	private int tamanhoLimite;
	private List<String> itens = new ArrayList<>();

	public ListaArquivosRecentes(int tamanhoLimite) {
		this.tamanhoLimite = tamanhoLimite;
	}

	public boolean estahVazia() {
		return itens.isEmpty();
	}

	public void adicionar(String item) {
		itens.remove(item);
		itens.subList(0, 0).add(item);
		if (itens.size() > tamanhoLimite) {
			itens.remove(tamanhoLimite);
		}
	}

	@Override
	public Iterator<String> iterator() {
		return itens.iterator();
	}

}

package gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List <FestasCadastradas> lista = new ArrayList<>();

	public void adiciona(FestasCadastradas festa) {
		Banco.lista.add(festa);
	}
	
	public List<FestasCadastradas> getFestasCadastradas() {
		return Banco.lista;
	}
}

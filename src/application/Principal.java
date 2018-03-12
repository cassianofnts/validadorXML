package application;

import java.util.List;

import arquivos.LeituraArquivos;
import arquivos.Municipio;

public class Principal {
	long start = System.currentTimeMillis();
	String data;

	public Principal(String data) {
		this.data = data;
	}

	void executar(List<Municipio> listaMunicipios) {
		for(Municipio m : listaMunicipios) {
			List<String> arquivos = LeituraArquivos.obterListaArquivos(m.getNome(), "xml");
		}
	}
}

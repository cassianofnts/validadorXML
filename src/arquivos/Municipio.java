package arquivos;

public class Municipio {
	String nome;
	int qtd;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Municipio(String nome, int qtd) {
		super();
		this.nome = nome;
		this.qtd = qtd;
	}

	public void imprime() {
		System.out.println(nome + " " + qtd);
	}

}

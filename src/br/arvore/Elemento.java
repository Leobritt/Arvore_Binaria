package br.arvore;

/*Bolinha da arvore*/
public class Elemento <TIPO>{
	
	private TIPO valor;
	
	private Elemento<TIPO> esquerda;
	
	private Elemento<TIPO> direita;


	public Elemento(TIPO novovalor) {
		this.valor = novovalor;
		/*os descendetes serão iniciados como null, pois eles não necessariamente vão existir*/
		this.direita = null;
		this.esquerda = null;
	}

	public TIPO getValor() {
		return valor;
	}

	public void setValor(TIPO valor) {
		this.valor = valor;
	}

	public Elemento<TIPO> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Elemento<TIPO> esquerda) {
		this.esquerda = esquerda;
	}

	public Elemento<TIPO> getDireita() {
		return direita;
	}

	public void setDireita(Elemento<TIPO> direita) {
		this.direita = direita;
	}

	@Override
	public String toString() {
		return "Elemento [valor=" + valor + ", esquerda=" + esquerda + ", direita=" + direita + "]";
	}
	
}

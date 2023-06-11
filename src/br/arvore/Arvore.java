package br.arvore;

public class Arvore<TIPO extends Comparable> {
	/*
	 * Em ordem 1- esquerda, 2- cima, 3- direita OBS: se tiver filho repete
	 */

	private Elemento<TIPO> raiz;

	public Arvore() {
		this.raiz = null;
	}

	public void add(TIPO valor) {
		Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);

		if (raiz == null) {
			this.raiz = novoElemento;
		} else {
			Elemento<TIPO> elementoAtual = this.raiz;

			while (true) {
				/*
				 * Comparação se é menor que o atual Menor que o atual vai para esquerda
				 */
				/*
				 * Método compareTo() retorna 1 qndo é maior, 0 qndo é igual ou -1 qndo é menor
				 */
				if (novoElemento.getValor().compareTo(elementoAtual.getValor()) == -1) {
					/* atual tem filho na esquerda? */
					if (elementoAtual.getEsquerda() != null) {
						/* descendo para esquerda */
						elementoAtual = elementoAtual.getEsquerda();
					} else {
						/* se tiver vazio ele irá se tornar o elemento da esquerda */
						elementoAtual.setEsquerda(novoElemento);
						break;
					}

				}
				/* Maior ou igual que o atual vai para direita */
				else {
					/* atual tem filho na direita */
					if (elementoAtual.getDireita() != null) {
						/* descendo para direita */
						elementoAtual = elementoAtual.getDireita();
					} else {
						/* se tiver vazio ele irá se tornar o elemento da direita */
						elementoAtual.setDireita(novoElemento);
						break;
					}
				}
			}
		}

	}

	public Elemento<TIPO> getRaiz() {
		return raiz;
	}

	public void addEsquerda(TIPO valor) {
		Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);

		if (raiz == null) {
			this.raiz = novoElemento;
		} else {
			Elemento<TIPO> elementoAtual = this.raiz;

			while (true) {

			}
		}
	}

	public void emOrdem(Elemento<TIPO> atual) {
		if (atual != null) {
			emOrdem(atual.getEsquerda());
			System.out.println(atual.getValor());
			emOrdem(atual.getDireita());
		}

	}

	public void preOrdem(Elemento<TIPO> atual) {
		if (atual != null) {
			System.out.println(atual.getValor());
			preOrdem(atual.getEsquerda());
			preOrdem(atual.getDireita());
		}

	}

	public void posOrdem(Elemento<TIPO> atual) {
		if (atual != null) {
			posOrdem(atual.getEsquerda());
			posOrdem(atual.getDireita());
			System.out.println(atual.getValor());

		}

	}
}

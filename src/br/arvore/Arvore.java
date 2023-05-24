package br.arvore;

public class Arvore<TIPO extends Comparable> {
	
	private Elemento<TIPO> raiz;

	public Arvore() {
		this.raiz = null;
	}
	
	public void add(TIPO valor) {
		Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);
		
		if (raiz == null) {
			this.raiz = novoElemento;
		}else {
			Elemento<TIPO> elementoAtual = this.raiz;
			
			while (true) {
				/*Comparação se é menor que o atual
				 *Menor que o atual vai para esquerda*/
				/*Método compareTo() retorna 1 qndo é maior, 0 qndo é igual ou -1 qndo é menor*/
				if (novoElemento.getValor().compareTo(elementoAtual.getValor()) == -1) {
					/*atual tem filho na esquerda?*/
					if (elementoAtual.getEsquerda() != null) {
						/*descendo para esquerda*/
						elementoAtual = elementoAtual.getEsquerda();
					}else {
						/*se tiver vazio ele irá se tornar o elemento da esquerda*/
						elementoAtual.setEsquerda(novoElemento);
						break;
					}
				
				}
				/*Maior ou igual que o atual vai para direita*/
				else {
					/*atual tem filho na direita*/
					if (elementoAtual.getDireita() != null) {
						/*descendo para direita*/
						elementoAtual = elementoAtual.getDireita();
					}else {
						/*se tiver vazio ele irá se tornar o elemento da direita*/
						elementoAtual.setDireita(novoElemento);
						break;
					}
				}
			}
		}
		
	}

	@Override
	public String toString() {
		return "Arvore [raiz=" + raiz + "]";
	}
	
}

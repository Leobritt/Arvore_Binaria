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
	public Boolean remover(TIPO valor) {
		/*Buscar elemento na arovre*/
		Elemento<TIPO> atual = this.raiz;
		Elemento<TIPO> paiAtual = null;
		
		while (atual != null) {
			/*igual ao valor que estamos procurando?*/
			if (atual.getValor().equals(valor)) {
				break;
			}
			/*Se for diferente*/
			else if(valor.compareTo(atual.getValor()) == -1){/*valor procurado é menor que o atual*/
				paiAtual = atual;
				atual = atual.getEsquerda();
				
			/*Se o valor procurado for maior q o atual vai para direita*/
			}else {
				paiAtual = atual;
				atual = atual.getDireita();
			}
		}
		/*verificacao de existencia*/
		if (atual != null) {
			
			/*Elemento tem 2 filhos ou somente filhos a direita*/
			if (atual.getDireita() != null) {
				
				
				Elemento<TIPO> substituto = atual.getDireita();
				Elemento<TIPO> paiSubstituto = atual;

				while (substituto.getEsquerda() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getEsquerda();
				}
				
				substituto.setEsquerda(atual.getEsquerda());
				
				if (paiAtual != null) {
					if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {/*atual menor q paiAtual*/
						paiAtual.setEsquerda(substituto);

					}else {
						paiAtual.setDireita(substituto);

					}
					
				}else {//se n tem paiAtual, entao é a raiz
					this.raiz = substituto;
				}
				
				
				
				
				/*removeu o elemento da arvore*/
				if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {/*substituto menor q paiSubstituto*/
					paiSubstituto.setEsquerda(null);

				}else {
					paiSubstituto.setDireita(null);

				}
				
			/*Sem filhos*/	
			
			/*Elemento tem filho só na esquerda*/
			}else if (atual.getEsquerda() != null) {
				
				Elemento<TIPO> substituto = atual.getEsquerda();
				Elemento<TIPO> paiSubstituto = atual;

				while (substituto.getDireita() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getDireita();
				}
				
				if (paiAtual != null) {
					if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {/*atual menor q paiAtual*/
						paiAtual.setEsquerda(substituto);

					}else {
						paiAtual.setDireita(substituto);

					}
					
				}else {//se n tem paiAtual, entao é a raiz
					this.raiz = substituto;
				}
				
				
				
				
				/*removeu o elemento da arvore*/
				if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {/*substituto menor q paiSubstituto*/
					paiSubstituto.setEsquerda(null);

				}else {
					paiSubstituto.setDireita(null);

				}
				
			/*Sem filhos*/	
			}else {
				if (paiAtual != null) {
					if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {/*atual menor q paiAtual*/
						paiAtual.setEsquerda(null);

					}else {
						paiAtual.setDireita(null);

					}
				}else {
					this.raiz = null;
				}
				
			}
			
			return true;
		}else {
			return false;
		}
		

	}
}

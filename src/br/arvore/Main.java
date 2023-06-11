package br.arvore;

public class Main {
	public static void main(String[] args) {
		Arvore<Integer> arvore = new Arvore<Integer>();
		arvore.add(10);
		arvore.add(8);
		arvore.add(5);		
		arvore.add(9);
		arvore.add(7);
		arvore.add(18);
		arvore.add(13);
		arvore.add(20);
		
		System.out.println("\nEm ordem");
		arvore.emOrdem(arvore.getRaiz());
		
		
		System.out.println("\nPré ordem");
		arvore.preOrdem(arvore.getRaiz());
		
		System.out.println("\nPos ordem");
		arvore.posOrdem(arvore.getRaiz());
	}
}

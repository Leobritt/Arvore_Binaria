package br.arvore;

public class Main {
	public static void main(String[] args) {
		Arvore<Integer> arvore = new Arvore<Integer>();
		arvore.add(2);
		arvore.add(20);
		
		System.out.println(arvore);
	}
}

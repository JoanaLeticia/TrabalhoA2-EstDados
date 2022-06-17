package arvoreBuscaBinaria;

/**
 * Trabalho da A2 - Estrutura de Dados 2022/1 | Sistemas de Informação - 3º Período
 * Alunos: Joana Letícia, Luiz Cláudio e Werbton
 * 
 * Problema: Uma Ávore Binária de Busca está desbalanceada e é preciso balanceá-la.
 * 
 * Objetivo: Converter uma determinada árvore binária de busca em uma árvore binária
 * de busca com a altura balanceada, ou seja balanceada.
 */

public class Principal {
	public static void main(String[] args) {
		No raiz = new No(50);
		raiz.esquerda = new No(25);
		raiz.esquerda.esquerda = new No(13);
		raiz.esquerda.esquerda.esquerda = new No(6);
		raiz.esquerda.esquerda.esquerda.esquerda = new No(3);
		raiz.esquerda.esquerda.esquerda.esquerda.esquerda = new No(15);
		
		raiz = ArvoreBuscaBinaria.construirArvoreBalanceada(raiz);
		
		System.out.println("PRÉ-ORDEM: ");
		ArvoreBuscaBinaria.preOrdem(raiz);
	}
}

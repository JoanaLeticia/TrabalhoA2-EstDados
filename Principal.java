package arvoreBuscaBinaria;

/**
 * Trabalho da A2 - Estrutura de Dados 2022/1 | Sistemas de Informa��o - 3� Per�odo
 * Alunos: Joana Let�cia, Luiz Cl�udio e Werbton
 * 
 * Problema: Uma �vore Bin�ria de Busca est� desbalanceada e � preciso balance�-la.
 * 
 * Objetivo: Converter uma determinada �rvore bin�ria de busca em uma �rvore bin�ria
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
		
		System.out.println("PR�-ORDEM: ");
		ArvoreBuscaBinaria.preOrdem(raiz);
	}
}

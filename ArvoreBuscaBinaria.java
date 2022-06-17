package arvoreBuscaBinaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBuscaBinaria {
	private No raiz;
	
	// CONSTRUTOR
	public ArvoreBuscaBinaria() {
		this.raiz = null;
	}

	// GETTERs E SETTERs
	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	// M�todo que faz a travessia em PR�-ORDEM na �rvore
	public static void preOrdem (No raiz) {
		if (raiz == null)	// Ponto de parada
			return;
		
		System.out.println(raiz.valor + " ");
		preOrdem(raiz.esquerda);
		preOrdem(raiz.direita);
	}
	
	/**
	 *  M�todo recursivo que desloca os n�s de uma determinada �rvore bin�ria de busca
	 *  para uma lista ordenada EM-ORDEM.
	 */
	public static void deslocaNo(No raiz, List<No> no) {
		if (raiz == null)	// Ponto de parada
			return;
		
		deslocaNo(raiz.esquerda, no);
		no.add(raiz);
		deslocaNo(raiz.direita, no);
	}
	
	/**
	 * M�todo recursiva que constr�i uma �rvore bin�ria de busca balanceada a partir
	 * da lista de n�s ordenados.
	 */
	public static No criarArvoreBalanceada(List<No> no, int comeco, int fim) {
		if (comeco > fim)
			return null;	// Ponto de parada
		
		// Encontra o �ndice do meio
		int meio = (comeco + fim) / 2;
		
		No raiz = no.get(meio);	// A ra�z ser� o n� que est� no �ndice do meio
		
		// Construindo recursivamente as sub�rvores da esquerda e da direita
		raiz.esquerda = criarArvoreBalanceada(no, comeco, meio - 1);
		raiz.direita = criarArvoreBalanceada(no, meio + 1, fim);
		
		return raiz;
	}
	
	/**
	 *  M�todo que constr�i a �rvore bin�ria de busca balanceada a partir
	 *  de uma �rvore bin�ria de busca desbalanceada
	 */
	public static No construirArvoreBalanceada(No raiz) {
		// Desloca os n�s da �rvore para uma lista ordenada
		List<No> no = new ArrayList<>();
		deslocaNo(raiz, no);
		
		// Constr�i a �rvore balanceada a partir dos n�s ordenados da outra �rvore
		return criarArvoreBalanceada(no, 0, no.size() - 1);
	} 
	
	// M�todo que verifica se o N� est� na �rvore ou n�o
	public boolean contemNo(int valor) {
		return contemNo(raiz, valor);
	}
	private boolean contemNo(No no, int valor) {
		if (no == null)
			return false;
		if (valor < no.valor)
			return contemNo(no.esquerda, valor);
		if (valor > no.valor)
			return contemNo(no.direita, valor);
		return true;
	}
	
	// M�todo que adiciona um N� na �rvore
	// Retorna true se conseguir inserir, e falso caso n�o consiga
	public boolean inserirNo(int valor) {
		if (contemNo(valor))
			return false;
		raiz = inserir(raiz, valor);
		return true;
	}
	private No inserir(No no, int valor) {
		if (no == null)
			return new No(valor);
		else if (valor < no.valor)
			no.esquerda = inserir(no.esquerda, valor);
		else if (valor > no.valor)
			no.direita = inserir(no.direita, valor);
		return no;
	}
	
	// M�todo que remove um N� da �rvore
	// Retorna true se conseguir remover, e falso caso n�o consiga
	public boolean remover(int valor) {
		if (!contemNo(valor))
			return false;
		raiz = remover(raiz, valor);
		return true;
	}
	private No remover(No no, int valor) {
		if (valor < no.valor)
			no.esquerda = remover(no.esquerda, valor);
		else if (valor > no.valor)
			no.direita = remover(no.direita, valor);
		else if (no.esquerda == null)
			no = no.direita;
		else if (no.direita == null)
			no = no.esquerda;
		else {
			No max = no.esquerda;
			while (max.direita != null) {
				no.valor = max.valor;
				no.esquerda = remover(no.esquerda, max.valor);
			}
		}
		return no;
	}
	
	// M�todo recursivo de impress�o em ordem
		public void emOrdem(No atual) {
			if (atual != null) {
				emOrdem(atual.esquerda);
				System.out.println(atual.esquerda);
				emOrdem(atual.direita);
			}
		}
		
		
		// M�todo recursivo de impress�o de p�s-ordem
		public void posOrdem(No atual) {
			if (atual != null) {
				posOrdem(atual.esquerda);
				posOrdem(atual.direita);
				System.out.println(atual.valor);
			}
		}
}

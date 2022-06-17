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
	
	// Método que faz a travessia em PRÉ-ORDEM na árvore
	public static void preOrdem (No raiz) {
		if (raiz == null)	// Ponto de parada
			return;
		
		System.out.println(raiz.valor + " ");
		preOrdem(raiz.esquerda);
		preOrdem(raiz.direita);
	}
	
	/**
	 *  Método recursivo que desloca os nós de uma determinada árvore binária de busca
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
	 * Método recursiva que constrói uma árvore binária de busca balanceada a partir
	 * da lista de nós ordenados.
	 */
	public static No criarArvoreBalanceada(List<No> no, int comeco, int fim) {
		if (comeco > fim)
			return null;	// Ponto de parada
		
		// Encontra o índice do meio
		int meio = (comeco + fim) / 2;
		
		No raiz = no.get(meio);	// A raíz será o nó que está no índice do meio
		
		// Construindo recursivamente as subárvores da esquerda e da direita
		raiz.esquerda = criarArvoreBalanceada(no, comeco, meio - 1);
		raiz.direita = criarArvoreBalanceada(no, meio + 1, fim);
		
		return raiz;
	}
	
	/**
	 *  Método que constrói a árvore binária de busca balanceada a partir
	 *  de uma árvore binária de busca desbalanceada
	 */
	public static No construirArvoreBalanceada(No raiz) {
		// Desloca os nós da árvore para uma lista ordenada
		List<No> no = new ArrayList<>();
		deslocaNo(raiz, no);
		
		// Constrói a árvore balanceada a partir dos nós ordenados da outra árvore
		return criarArvoreBalanceada(no, 0, no.size() - 1);
	} 
	
	// Método que verifica se o Nó está na árvore ou não
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
	
	// Método que adiciona um Nó na árvore
	// Retorna true se conseguir inserir, e falso caso não consiga
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
	
	// Método que remove um Nó da árvore
	// Retorna true se conseguir remover, e falso caso não consiga
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
	
	// Método recursivo de impressão em ordem
		public void emOrdem(No atual) {
			if (atual != null) {
				emOrdem(atual.esquerda);
				System.out.println(atual.esquerda);
				emOrdem(atual.direita);
			}
		}
		
		
		// Método recursivo de impressão de pós-ordem
		public void posOrdem(No atual) {
			if (atual != null) {
				posOrdem(atual.esquerda);
				posOrdem(atual.direita);
				System.out.println(atual.valor);
			}
		}
}

package ordenacao;

public class Ordenar {
	
	public static long tempoQuickSort;
	public static long tempoSelectionSort;
	public static long tempoBubbleSort;
	
	//Quick Sort
	public static void QuickSort(int v[], int esquerda, int direita) {
		
		long starttempo = System.nanoTime(); //inicia o timer de ordenação para futura comparação
		
		//algoritimo Quick Sort
		int esq = esquerda;
		int dir = direita;
		int pivo = v[(esq + dir) / 2];
		int troca;

		while (esq <= dir) {
			while (v[esq] < pivo) {
				esq = esq + 1;
			}
			while (v[dir] > pivo) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		
		if (dir > esquerda) {
			QuickSort(v, esquerda, dir);
		}
			

		if (esq < direita) {
			QuickSort(v, esq, direita);
		}
		
		long endtempo = System.nanoTime(); //termina o timer de ordenação para futura comparação
		
		tempoQuickSort = endtempo - starttempo; //calcula o tempo em nanosegundos de demora para a ordenação
	}
	
	//Selection Sort
	public static void SelectionSort(int v[]) {
		
		long starttempo = System.nanoTime(); //inicia o timer de ordenação para futura comparação
		
		//algoritimo Selection Sort
		int tamanho = v.length;
		
		for (int i = 0; i < tamanho-1; i++) {
			int minimoIndex = i;
			
			for (int j = i+1; j < tamanho; j++) {
				if(v[j] < v[minimoIndex]) {
					minimoIndex = j;
				}
			}
			
			int temp = v[minimoIndex];
			v[minimoIndex] = v[i];
			v[i] = temp;
			
		}
		
		long endtempo = System.nanoTime(); //termina o timer de ordenação para futura comparação
		
		tempoSelectionSort = endtempo - starttempo; //calcula o tempo em nanosegundos de demora para a ordenação
	}
	
	//Bubble Sort
	public static void BubbleSort(int v[]) {
		
		long starttempo = System.nanoTime(); //inicia o timer de ordenação para futura comparação
		
		//algoritimo Bubble Sort
		for(int i = 0; i < v.length - 1; i++) {
			for(int j = 0; j < v.length - 1 - i; j++) {
				if(v[j] > v[j + 1]) {
					int aux = v[j];
			        v[j] = v[j + 1];
			        v[j + 1] = aux;
			    }
			}
		}
		
		long endtempo = System.nanoTime(); //termina o timer de ordenação para futura comparação
		
		tempoBubbleSort = endtempo - starttempo; //calcula o tempo em nanosegundos de demora para a ordenação
	}
	
	/*
	//testar todos
	public static void main(String args[]) {
		//Quick Sort
			int teste[] = {100, 15, 65, 65, 76, 3, 4, 6, 8, 89};
	
			//esquerda = começo da lista
			//direita = final da lista
			
			System.out.println(" Quick Sort:");
			
			for (int i = 0; i < teste.length; i++) {
				System.out.print(" " + teste[i]);
			}
			
			System.out.println(" ");
			
			QuickSort(teste, 0, teste.length-1);
			
			for (int i = 0; i < teste.length; i++) {
				System.out.print(" " + teste[i]);
			}
			
			System.out.println(" ");
			System.out.println(" tempo em nanosegundos: " + tempoQuickSort);
		//Quick Sort
			
		System.out.println(" ");
		System.out.println(" ");
		
		//Selection Sort
			int teste2[] = {100, 15, 65, 65, 76, 3, 4, 6, 8, 89};
		
			System.out.println(" Selection Sort:");
			
			for (int i = 0; i < teste2.length; i++) {
				System.out.print(" " + teste2[i]);
			}
			
			System.out.println(" ");
			
			SelectionSort(teste2);
			
			for (int i = 0; i < teste2.length; i++) {
				System.out.print(" " + teste2[i]);
			}
			
			System.out.println(" ");
			System.out.println(" tempo em nanosegundos: " + tempoSelectionSort);
		//Selection Sort
		
		System.out.println(" ");
		System.out.println(" ");
			
		//Bubble Sort
			int teste3[] = {100, 15, 65, 65, 76, 3, 4, 6, 8, 89};
			
			System.out.println(" Bubble Sort:");
			
			for (int i = 0; i < teste3.length; i++) {
				System.out.print(" " + teste3[i]);
			}
			
			System.out.println(" ");
			
			BubbleSort(teste3);
			
			for (int i = 0; i < teste3.length; i++) {
				System.out.print(" " + teste3[i]);
			}
			
			System.out.println(" ");
			System.out.println(" tempo em nanosegundos: " + tempoBubbleSort);
		//Bubble Sort
	}
	//testar todos
	*/
}




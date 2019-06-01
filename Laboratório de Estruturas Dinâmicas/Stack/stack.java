import static java.lang.System.exit; 

class Pilha 
{ 
	No heap;

	private class No 
	{ 
		int elem;
		No pont;
	} 

	Pilha() 
	{ 
		this.heap = null; 
	} 

	public void push(int x)
	{ 
		No temp = new No(); 

		if (temp == null) { 
			System.out.print("\nSem heap!"); 
			return; 
		} 

		temp.elem = x; 
		temp.pont = heap; 
		heap = temp; 
	} 

	public boolean estaVazia() 
	{ 
		return heap == null; 
	} 

	public int mostrarHeap() 
	{ 
		if (!estaVazia()) { 
			return heap.elem; 
		} 
		else { 
			System.out.println("Pilha vazia!"); 
			return -1; 
		} 
	} 

	public void pop()
	{ 
		if (heap == null) { 
			System.out.print("\nSem elementos na pilha!"); 
			return; 
		} 

		heap = (heap).pont; 
	} 

	public void mostrar() 
	{ 
		if (heap == null) { 
			System.out.printf("\nSem elementos!"); 
			exit(1); 
		} 
		else { 
			No temp = heap; 
			
			while (temp != null) { 
				System.out.printf("|%d|\n", temp.elem); 
				temp = temp.pont; 
			} 
		} 
	}

	public static void main(String[] args) 
	{ 
		Pilha pilha = new Pilha(); 

		pilha.push(11); 
		pilha.push(22); 
		pilha.push(33); 
		pilha.push(44); 

		//pilha.pop(); 
		
		pilha.mostrar(); 
	} 

}  

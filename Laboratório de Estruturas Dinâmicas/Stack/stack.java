import static java.lang.System.exit; 

class Pilha 
{ 
	No heap;

	private class No 
	{ 
		int data;
		No link;
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

		temp.data = x; 
		temp.link = heap; 
		heap = temp; 
	} 

	public boolean estaVazia() 
	{ 
		return heap == null; 
	} 

	public int mostrarHeap() 
	{ 
		if (!estaVazia()) { 
			return heap.data; 
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

		heap = (heap).link; 
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
				System.out.printf("|%d|\n", temp.data); 
				temp = temp.link; 
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

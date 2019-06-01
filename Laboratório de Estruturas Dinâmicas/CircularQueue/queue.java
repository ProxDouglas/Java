import java.util.*; 

class FilaCircular 
{ 
	
	static class No 
	{ 
		int elem; 
		No pont; 
	} 
	
	static class Fila 
	{ 
		No inicio, fim; 
	} 
	
	static void adicionarElemento(Fila q, int valor) 
	{ 
		No temp = new No(); 
		temp.elem = valor; 

		if (q.inicio == null) {
			q.inicio = temp; 
		} else {
			q.fim.pont = temp; 
		}
		
		q.fim = temp; 
		q.fim.pont = q.inicio; 
	} 
	
	static int deletarElemento(Fila q) 
	{   
		int valor = 0;

		if (q.inicio == null) { 
			System.out.printf ("Fila vazia!"); 
			return Integer.MIN_VALUE; 
		} 
		if (q.inicio == q.fim) { 
			valor = q.inicio.elem; 
			q.inicio = null; 
			q.fim = null; 
		} else { 
			No temp = q.inicio; 
			valor = temp.elem; 
			q.inicio = q.inicio.pont;
			q.fim.pont = q.inicio; 
		} 
		
		return valor; 
	} 
	
	static void mostrarFila(Fila q) 
	{ 
		No temp = q.inicio; 

		System.out.printf("Fila\n"); 

		while (temp.pont != q.inicio) { 
			System.out.printf("[%d]->", temp.elem); 
			temp = temp.pont; 
		} 

		System.out.printf("[%d]\n\n", temp.elem); 
	} 
	
	public static void main(String args[]) 
	{ 
		Fila q = new Fila(); 
		q.inicio = q.fim = null; 
		
		adicionarElemento(q, 14); 
		adicionarElemento(q, 22);
		adicionarElemento(q, 6); 
		mostrarFila(q); 
		
		deletarElemento(q); 
		deletarElemento(q); 
		mostrarFila(q);

		adicionarElemento(q, 9); 
		adicionarElemento(q, 20);
		adicionarElemento(q, 25);
		mostrarFila(q); 
	}

} 
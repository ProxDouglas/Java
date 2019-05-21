import java.util.*; 

class FilaCircular 
{ 
	
	static class No 
	{ 
		int data; 
		No link; 
	} 
	
	static class Fila 
	{ 
		No inicio, fim; 
	} 
	
	static void adicionarElemento(Fila q, int valor) 
	{ 
		No temp = new No(); 
		temp.data = valor; 

		if (q.inicio == null) {
			q.inicio = temp; 
		} else {
			q.fim.link = temp; 
		}
		
		q.fim = temp; 
		q.fim.link = q.inicio; 
	} 
	
	static int deletarElemento(Fila q) 
	{   
		int valor = 0;

		if (q.inicio == null) { 
			System.out.printf ("Fila vazia!"); 
			return Integer.MIN_VALUE; 
		} 
		if (q.inicio == q.fim) { 
			valor = q.inicio.data; 
			q.inicio = null; 
			q.fim = null; 
		} else { 
			No temp = q.inicio; 
			valor = temp.data; 
			q.inicio = q.inicio.link; 
			q.fim.link= q.inicio; 
		} 
		
		return valor; 
	} 
	
	static void mostrarFila(Fila q) 
	{ 
		No temp = q.inicio; 

		System.out.printf("Fila\n"); 

		while (temp.link != q.inicio) { 
			System.out.printf("[%d]->", temp.data); 
			temp = temp.link; 
		} 

		System.out.printf("[%d]\n\n", temp.data); 
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
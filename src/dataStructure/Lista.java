//Documento sin acentos

package dataStructure;

/**
 * Representa un conjunto de elementos, en este caso un conjunto de nodos
 * los cuales se encuentran doblemente enlazados.
 * 
 * @author PauloLoaeza
 *
 * @param <E> objeto de tipo comparable que va a soportar la lista
 */
public class Lista<E extends Comparable<E>> {

	private Nodo<E> inicio;
	
	/**
	 * Crea una lista vacia
	 */
	public Lista() {
		this.inicio = null;
	}
	
	/**
	 * Verifica si la lista se encuentra vacia
	 * @return true si la lista esta vacia, false si no lo esta
	 */
	public boolean estaVacia() {
		return this.inicio == null;
	}

	/**
	 * Agrega un nuevo elemento al inicio de la lista
	 * @param elemento nuevo elemento en la lista
	 */
	public void insertarAlInicio(E elemento) {
		//Se crea un nuevo nodo el cual su valor = elemento
		Nodo<E> nuevo = new Nodo<E>(elemento);
		
		//Si la lista no esta vacia se unen los nodos nuevo e inicio
		if (!estaVacia()) {
			nuevo.setSiguiente(this.inicio);
			this.inicio.setAnterior(nuevo);
		}
		
		this.inicio = nuevo;
	}
	
	/**
	 * Agrega un nuevo elemento al final de la lista
	 * @param elemento nuevo elemento en la lista
	 */
	public void insertarAlFinal(E elemento) {
		//Se crea un nuevo nodo el cual su valor = elemento
		Nodo<E> nuevo = new Nodo<E>(elemento);
		
		//Si la lista esta vacia el nodo inicial sera el nuevo nodo
		if (estaVacia()) {
			this.inicio = nuevo;
		}
		else {
			//Nodo auxiliar para recorrer la lista
			Nodo<E> aux = this.inicio;
			
			//Se coloca el nodo auxiliar al final de la lista
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			
			//Se unen los nodos aux y nuevo
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
		}
	}
	
	/**
	 * Muestra todos los elementos de la lista en consola de izquierda a derecha 
	 * y viceversa
	 */
	public void mostrar() {
		
		//Si la lista esta vacia imprime el mensaje
		if (estaVacia()) {
			System.out.println("Lista sin elementos");
			return;
		}
		
		//Nodo auxiliar para recorrer
		Nodo<E> aux = this.inicio;
		
		//Nodo anterior para recorrer la lista en reversa
		Nodo<E> ant = null;
		
		//Recorrido normal
		while (aux != null) {
			System.out.print("{" + aux.getValor() + "}-");
			
			ant = aux;
			aux = aux.getSiguiente();
		}
		
		System.out.println();
		
		//Recorrido en reversa
		while (ant != null) {
			System.out.print("{" + ant.getValor() + "}-");
			ant = ant.getAnterior();
		}
		
	}
}
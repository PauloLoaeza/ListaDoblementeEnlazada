//Documento sin acentos

package dataStructure;

import exceptions.TokenNoEncontradoException;

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
	 * Agrega un nuevo elemento a la lista de manera ordenada de menor a mayor
	 * 
	 * El elemento se agregara comparando los valores de los nodos
	 * de izquierda a derecha y buscara su posicion en la lista
	 * 
	 * @param elemento nuevo elemento
	 */
	public void insertarDeMenorAMayor(E elemento) {
		//Se crea un nuevo nodo el cual su valor = elemento
		Nodo<E> nuevo = new Nodo<E>(elemento);

		//Si la lista esta vacia el nodo inicial sera el nuevo nodo
		if (estaVacia()) {
			this.inicio = nuevo;
		}
		else {
			//Nodo auxiliar para recorrer la lista
			Nodo<E> aux = this.inicio;

			//Nodo anterior al nodo aux
			Nodo<E> ant = null;

			/*
			 * Se recorre el nodo aux y ant  mientras no sea nulo y su valor sea
			 * menor al valor del nodo nuevo
			 */
			while (aux != null && nuevo.compareTo(aux) > 0) {
				ant = aux;
				aux = aux.getSiguiente();
			}

			//Si el auxiliar no avanzo, el nodo nuevo se agrega al inicio
			if (aux == this.inicio) {
				nuevo.setSiguiente(aux);
				aux.setAnterior(nuevo);
				this.inicio = nuevo;
			}
			else {
				//Se coloca el nodo nuevo entre los nodos ant y aux 
				if (aux != null) {
					nuevo.setSiguiente(aux);
					aux.setAnterior(nuevo);
				}

				nuevo.setAnterior(ant);
				ant.setSiguiente(nuevo);
			}
		}
	}

	/**
	 * Agrega un nuevo elemento a la lista de manera ordenada de mayor a menor
	 * 
	 * El elemento se agregara comparando los valores de los nodos
	 * de izquierda a derecha y buscara su posicion en la lista
	 * 
	 * @param elemento nuevo elemento
	 */
	public void insertarDeMayorAMenor(E elemento) {
		//Se crea un nuevo nodo el cual su valor = elemento
		Nodo<E> nuevo = new Nodo<E>(elemento);

		//Si la lista esta vacia el nodo inicial sera el nuevo nodo
		if (estaVacia()) {
			this.inicio = nuevo;
		}
		else {
			//Nodo auxiliar para recorrer la lista
			Nodo<E> aux = this.inicio;
			//Nodo anterior al nodo auxiliar
			Nodo<E> ant = null;

			/*
			 * Se recorre el nodo aux y ant  mientras no sea nulo y su valor sea
			 * mayor al valor del nodo nuevo
			 */
			while (aux != null && nuevo.compareTo(aux) < 0) {
				ant = aux;
				aux = aux.getSiguiente();
			}

			//Si el nodo auxiliar = inicio
			if (ant == null) {
				//Se agrega el nuevo elemento al inicio de la lista
				nuevo.setSiguiente(aux);
				aux.setAnterior(nuevo);
				this.inicio = nuevo;
			}
			else {
				//Se agrega el nodo nuevo entre los nodos aux y ant
				if (aux != null) {
					aux.setAnterior(nuevo);
					nuevo.setSiguiente(aux);
				}
				ant.setSiguiente(nuevo);
				nuevo.setAnterior(ant);
			}
		}
	}

	/**
	 * Determina el numero de elementos que existen en la lista
	 * @return total de elementos en la lista
	 */
	public int size() {
		int elementos = 0;

		//Nodo auxiliar para recorrer la lista
		Nodo<E> aux = this.inicio;

		//Recorre la lista y aumenta el numero de elementos cada vez que recorre
		while (aux != null) {
			elementos++;
			aux = aux.getSiguiente();
		}

		return elementos;
	}

	/**
	 * Elimina un elemento especifico de la lista.
	 * @param token elemento que sera borrado de la lista.
	 * @throws TokenNoEncontradoException lanza esta excepcion si el token no
	 * 		se encuentra en la lista o la lista esta vacia.
	 */
	public void eliminar(E token) throws TokenNoEncontradoException {
		if (estaVacia()) {
			throw new TokenNoEncontradoException("Token no encontrado");
		}

		//Nodo auxiliar para recorrer la lista
		Nodo<E> aux = this.inicio;

		//Recorre el nodo aux mientras no sea nulo y su valor != token
		while (aux != null && aux.getValor().compareTo(token) != 0) {
			aux = aux.getSiguiente();
		}

		//Si no encontro el elemento
		if (aux == null) {
			throw new TokenNoEncontradoException("Token no encontrado");
		}

		if (aux == this.inicio) {
			this.inicio = aux.getSiguiente();
			this.inicio.setAnterior(null);
		}
		else {
			if(aux.getSiguiente() != null) {
				aux.getSiguiente().setAnterior(aux.getAnterior());
			}

			aux.getAnterior().setSiguiente(aux.getSiguiente());
		}

		aux.setAnterior(null);
		aux.setSiguiente(null);
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
//DOCUMENTO SIN ACENTOS

package dataStructure;

/**
 * La clase nodo representa un elemento de la lista, en el cual contiene como
 * dato un valor de tipo generico y este valor debe implementar Comparable para que
 * pueda ser un elemento valido en el nodo.
 * 
 * @author PauloLoaeza
 *
 * @param T representa un objeto, el cual debe implementar Comparable.
 */
public class Nodo<T extends Comparable<T>> 
implements Comparable<Nodo<T>> {

	private T valor;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;

	/**
	 * Construye un nodo vacio.
	 */
	public Nodo() {
		this.valor = null;
		this.siguiente = null;
		this.anterior = null;
	}

	/**
	 * Construye un nodo con su respectivo valor
	 * @param valor valor del nodo
	 */
	public Nodo(T valor) {
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}

	/**
	 * Retorna el valor del nodo
	 * @return valor del nodo
	 */
	public T getValor() {
		return valor;
	}

	/**
	 * Asigna un valor a este nodo
	 * @param valor nuevo valor del nodo
	 */
	public void setValor(T valor) {
		this.valor = valor;
	}

	/**
	 * Retorna el nodo que se encuentra despues de este nodo
	 * @return nodo siguiente
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * Asigna un nodo despues de este nodo
	 * @param siguiente nodo que ira a continuacion de este nodo
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Retorna el nodo que se encuentra antes de este nodo
	 * @return nodo anterior
	 */
	public Nodo<T> getAnterior() {
		return anterior;
	}

	/**
	 * Asigna un nodo anterior a este nodo
	 * @param anterior nodo que ira antes de este nodo
	 */
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	/**
	 * Compara los valores que hay entre este nodo con el nodo that
	 */
	@Override
	public int compareTo(Nodo<T> that) {
		return this.valor.compareTo(that.valor);
	}

}
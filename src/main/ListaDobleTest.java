//Documento sin acentos

package main;

import dataStructure.Lista;
import exceptions.TokenNoEncontradoException;

/*
 * Clase para hacer pruebas con la clase Lista y sus metosos
 */
public class ListaDobleTest {

	public static void main(String... args) {
		//Test 1.- Crear una lista vacia y mostrar sus elementos
		Lista<Integer> lista = new Lista<Integer>();
		System.out.print("Test 1.- ");
		lista.mostrar();
		
		//Test 2.- Agregar tres elementos a la lista y mostrar la lista
		lista.insertarAlFinal(6);
		lista.insertarAlFinal(2);
		lista.insertarAlFinal(0);
		System.out.println("\nTest 2.- ");
		lista.mostrar();
		
		/*
		 * Test 3.- Crear una nueva lista e insertar 5 valores con el metodo
		 * insertarDeMenorAMayor() y mostrarla
		 */
		
		Lista<Integer> lista2 = new Lista<Integer>();
		lista2.insertarDeMenorAMayor(7);
		lista2.insertarDeMenorAMayor(3);
		lista2.insertarDeMenorAMayor(9);
		lista2.insertarDeMenorAMayor(8);
		lista2.insertarDeMenorAMayor(5);
		
		System.out.println("\n\nTest 3.- Inserccion de: 7, 3, 9, 8, 5");
		lista2.mostrar();
		
		/*
		 * Test 4.- Crear una nueva lista e insertar 5 valores con el metodo
		 * insertarDeMayorAMenor() y mostrarla
		 */
		Lista<Integer> lista3 = new Lista<Integer>();
		lista3.insertarDeMayorAMenor(7);
		lista3.insertarDeMayorAMenor(3);
		lista3.insertarDeMayorAMenor(9);
		lista3.insertarDeMayorAMenor(8);
		lista3.insertarDeMayorAMenor(5);
		
		System.out.println("\n\nTest 4.- Inserccion de: 7, 3, 9, 8, 5");
		lista3.mostrar();
		
		//Test 5.- Muestra el tamaño de las listas
		System.out.println("\n\nTest 5.\nTamaño de la lista 1 = " + lista.size());
		System.out.println("Tamaño de la lista 2 = " + lista2.size());
		System.out.println("Tamaño de la lista 3 = " + lista3.size());
		
		//Test 6.- Eliminar un elemento en la lista 3 y mostar la lista
		try {
			lista3.eliminar(5);
		} catch (TokenNoEncontradoException e) {
			e.printStackTrace();
		}
		System.out.println("\nTest 6.- Se eliminó el numero 5 de la lista 3");
		lista3.mostrar();
	}
}

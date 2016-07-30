//Documento sin acentos

package main;

import dataStructure.Lista;

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
	}
}

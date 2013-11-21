import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ComandosJuego {
	public String palabra;// palabra a adivinar
	public String adivina; // estado de lo que se esta adivinando
	public int canterrores;// fácil son 6 errores, normal son 4, difícil son 2
							// errores
	public ArrayList<String> lista;
	public int errores; // cantidad de errores
	public int nivel; // 1 es fácil;2 es normal; 3 es difícil
	public int cantpista; // cantidad de pistas usadas

	public ComandosJuego() // constructor
	{
		lista = new ArrayList<String>();
	}

	public String mostrarpista()// Da una pista y se aumenta la cantidad de
								// pistas usadas, pero si son mas de 3 pistas,
								// devuelve vacio
	{
		String aux = "";
		char ex;
		if (cantpista <= 3) {
			for (int i = 0; i < palabra.length(); i++) {
				ex = adivina.charAt(i);
				if (ex == '_') {
					aux += palabra.charAt(i);
					cantpista++;
					break;
				}
			}
		}
		return aux;
	}

	public boolean letracorrecta(String letra)// Verifica que la letra ingresada
												// sea la correcta
	{
		letra = letra.toLowerCase();
		char l = letra.charAt(0);
		if (l <= 96 || l >= 123) {
			return false;
		}
		return true;
	}

	public boolean ingresoletra(String letra) // Cuando entra una letra
	{
		if (letracorrecta(letra)) {
			if (verificarletra(letra)) {
				rellenar(letra);
				return true;
			} else {
				errores++;
				return true;
			}
		}
		return false;
	}

	public int verificarganador()// Verifica el estado del juego
	{
		if (errores == canterrores) {
			return -1; // Perdio
		}
		if (palabra.equals(adivina)) {
			return 1;// gano
		}
		return 0;// Sigue en juego
	}

	public void rellenar(String letra) // rellena el string adivina si la letra
										// es correcta
	{
		String aux = "";
		String ex;
		for (int i = 0; i < palabra.length(); i++) {
			ex = "";
			ex += palabra.charAt(i);
			if (letra.contains(ex) == true) {
				aux += ex;
			} else {
				aux += adivina.charAt(i);
			}
		}
		adivina = aux;
	}

	public boolean verificarletra(String letra)// verifica si la letra esta en
												// la palabra
	{
		return palabra.contains(letra);
	}

	public void obtenerpalabras()// cargar palabras del diccionario, selecciona
									// una de esta y crea los espacios de
									// adivina
	{
		lista.clear();
		cantpista = 0;
		try {
			String linea = "";
			FileReader leerArchivo = new FileReader("Archivo.txt");
			BufferedReader buffer = new BufferedReader(leerArchivo);
			while ((linea = buffer.readLine()) != null) {
				lista.add(linea);
			}
			buffer.close();
		} catch (Exception e) {
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}

	public void poneradivina() { //pone en blanco la palabra a adivinar
		String res = "";
		for (int i = 0; i < palabra.length(); i++) {
			res += "_";
		}
		adivina = res;
	}


	public void agregarpalabra(String palabra)// agregar palabras al diccionario
	{
		lista.add(palabra);
		try {
			File f = new File("Archivo.txt");
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			for (int i = 0; i < lista.size(); i++) {
				bw.write(lista.get(i));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
		}
		;
	}

	public void seleccionarnivel(int ni)// Pone la cantidad de errores de
										// acuerdo al nivel
	{
		switch (ni) {
		case 1:
			canterrores = 6;
			nivel = ni;
			break;
		case 2:
			canterrores = 4;
			nivel = ni;
			break;
		case 3:
			canterrores = 2;
			nivel = ni;
			break;
		}
		errores = 0;
	}

}

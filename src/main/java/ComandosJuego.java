
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ComandosJuego {
	public Palabras seleccionado;
	public String palabra;// palabra a adivinar
	public String adivina; // estado de lo que se esta adivinando
	public int canterrores;// fácil son 6 errores, normal son 4, difícil son 2 errores
	public ArrayList<Palabras> lista;
	public int errores; // cantidad de errores
	public int nivel; // 1 es fácil;2 es normal; 3 es difícil
	public int cantpista; // cantidad de pistas usadas
	public int puntage;

	public ComandosJuego() // constructor
	{
		lista = new ArrayList<Palabras>();
	}

	public String mostrarpista()// Da una pista y se aumenta la cantidad de pistas usadas, pero si son mas de 3 pistas, devuelve vacio
	{
		String aux = "";
		char ex;
		if (cantpista <= 3) 
		{
			for (int i = 0; i < palabra.length(); i++) 
			{
				ex = adivina.charAt(i);
				if (ex == '_') {
					aux += palabra.charAt(i);
					cantpista++;
					break;
				}
			}
			puntage = puntage-5;
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
				puntage = puntage + 10;
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

	public final void obtenerpalabras() throws IOException, ClassNotFoundException// cargar palabras del diccionario
	{
		lista.clear();
		cantpista = 0;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("diccionario.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         while(fileIn.available() > 0)
	         {
	        	 Palabras aux = new Palabras();
	        	 aux = (Palabras) in.readObject();
	        	 lista.add(aux);
	         }
	         in.close();
	         fileIn.close();
	         lista.remove(null);
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }
	}
	
	public final void obtenerpalabrascriterionivel(int nivel, String cate)
	{
		ArrayList<Palabras> nue = new ArrayList<Palabras>();
		Palabras aux = new Palabras();
		for(int i = 0; i< lista.size(); i++)
		{
			aux = lista.get(i);
			if(aux.dificultad == nivel && aux.categoria.equals(cate))
			{
				nue.add(aux);
			}
		}
		lista = nue;
	}

	public void poneradivina() { //pone en blanco la palabra a adivinar
		String res = "";
		for (int i = 0; i < palabra.length(); i++) {
			res += "_";
		}
		adivina = res;
	}

	public void seleccionarpalabra()
	{
		int pos = (int) (Math.random()*lista.size());
		seleccionado = lista.get(pos);
		palabra= lista.get(pos).palabra;
		lista.remove(seleccionado);
		lista.remove(null);
	}
	

	public final void agregarpalabra(Palabras palabra) throws IOException// agregar palabras al diccionario
	{
		palabra.palabra = palabra.palabra.toLowerCase();
		lista.add(palabra);
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream("diccionario.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         while(lista.isEmpty() == false)
	         {
	        	 Palabras e = lista.get(0);
	        	 System.out.printf(e.palabra);
	        	 out.writeObject(e);
	        	 lista.remove(0);
	         }
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		
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

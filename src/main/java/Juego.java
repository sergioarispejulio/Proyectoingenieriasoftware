
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

public class Juego {
	public Palabras seleccionado;
	
	private Diccionario diccionario;
	private Palabra palabra;
	private String adivina;
	private int cantErrores;
	private int puntaje;
	
	private int erroresNivel;
	private int nivel;
	private int cantPistas;

	public Juego() {
		this.diccionario = new Diccionario();
		this.palabra = new Palabra();
		this.adivina = palabra.dibujarPalabraConEspacios();
		this.cantErrores = 0;
		this.puntaje = 0;
		this.erroresNivel = 0;
		this.nivel = -1;
		this.cantPistas = 0;
	}
	
	public Juego(String palabra) {
		this.diccionario = new Diccionario();
		this.palabra = new Palabra();
		this.adivina = this.palabra.dibujarPalabraConEspacios();
		this.cantErrores = 0;
		this.puntaje = 0;
		this.erroresNivel = 0;
		this.nivel = -1;
		this.cantPistas = 0;
	}

	public String mostrarPista()// Da una pista y se aumenta la cantidad de pistas usadas, pero si son mas de 3 pistas, devuelve vacio
	{
		String aux = "";
		char ex;
		if (cantPistas <= 3) 
		{
			for (int i = 0; i < palabra.getPalabra().length(); i++) 
			{
				ex = adivina.charAt(i);
				if (ex == '_') {
					aux += palabra.getPalabra().charAt(i);
					cantPistas++;
					break;
				}
			}
			reducirPuntaje();
		}
		return aux;
	}

	public boolean verificarLetraCorrecta(String letra) {
		letra = letra.toLowerCase();
		char l = letra.charAt(0);
		if (l <= 96 || l >= 123) {
			return false;
		}
		return true;
	}
	
	public boolean verificarLetraEnPalabra(String letra) {
		return palabra.getPalabra().contains(letra);
	}
	
	public void dibujarLetraEnPalabra(String letra) 
	{
		String aux = "";
		String ex;
		for (int i = 0; i < palabra.getPalabra().length(); i++) {
			ex = "";
			ex += palabra.getPalabra().charAt(i);
			if (letra.contains(ex) == true) {
				aux += ex;
			} else {
				aux += adivina.charAt(i);
			}
		}
		adivina = aux;
	}

	public boolean ingresarLetra(String letra)
	{
		if (verificarLetraCorrecta(letra))
		{
			if (verificarLetraEnPalabra(letra))
			{
				dibujarLetraEnPalabra(letra);
				puntaje = puntaje + 10;
				return true;
			} else {
				cantErrores++;
				return true;
			}
		}
		return false;
	}

	public int verificarGanador()// Verifica el estado del juego
	{
		if (cantErrores == erroresNivel) {
			return -1; // Perdio
		}
		if (palabra.equals(adivina)) {
			return 1;// gano
		}
		return 0;// Sigue en juego
	}
	
	public String dibujarPalabraConCasillasVacias()
	{
		return adivina;
	}

	public void poneradivina() { //pone en blanco la palabra a adivinar
		String res = "";
		for (int i = 0; i < palabra.getPalabra().length(); i++) {
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

	public void seleccionarNivel(int niv)
	{
		switch (niv) {
		case 1:
			erroresNivel = 6;
			nivel = niv;
			break;
		case 2:
			erroresNivel = 4;
			nivel = niv;
			break;
		case 3:
			erroresNivel = 2;
			nivel = niv;
			break;
		}
		cantErrores = 0;
	}
	
	public void reducirPuntaje() {
		puntaje-=5;
	}
	
	
	
	public String dibujarMunheco() {
		String m = "";
		if(nivel == 1)
		{
			m = munhecoNivelFacil();
		}
		if(nivel == 2){
			m = munhecoNivelMedio();
		}
		if(nivel == 3){
			m = munhecoNivelDificil();
		}
		return m;
	}
	
	public String munhecoNivelFacil() {
		String muneco = "";
		if(cantErrores == 1){
			muneco = muneco + "    O    ";
		}
		if(cantErrores == 2){
			muneco = muneco + "    O  <BR>"+
							  "   /   <BR>";
		}
		if(cantErrores == 3){
			muneco = muneco + "    O   <BR>"+
							  "   /|   <BR>";
		}
		if(cantErrores == 4){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(cantErrores == 5){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   /      ";
		}
		if(cantErrores == 6){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\   ";
		}
		return muneco;
	}
	
	public String munhecoNivelMedio() {
		String muneco = "";
		if(cantErrores == 1){
			muneco = muneco + "    O   <BR>"+
							  "   /    <BR>";
		}
		if(cantErrores == 2){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(cantErrores == 3){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   /      ";
		}
		if(cantErrores == 4){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\   ";
		}
		return muneco;
	}
	
	public String munhecoNivelDificil() {
		String muneco = "";
		if(cantErrores == 1){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(cantErrores == 2){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\    ";
		}
		return muneco;
	}

	// GETS
	
	public Palabra getPalabra() {
		return palabra;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getCantidadErrores(){
		return cantErrores;
	}
	
	public String getAdivina() {
		return adivina;
	}
	
	public Diccionario getDiccionario() {
		return diccionario;
	}
	
	public int getCantPistas() {
		return cantPistas;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	// SETS
	
	public void setPalabra(Palabra nuevaPalabra) {
		this.palabra = nuevaPalabra;
		this.adivina = nuevaPalabra.dibujarPalabraConEspacios();
	}
	
	public void setPuntaje(int nuevoPuntaje) {
		this.puntaje = nuevoPuntaje;
	}
	
	public void setCantidadErrores(int nuevaCantErrores) {
		this.cantErrores = nuevaCantErrores;
	}
	
	public void setAdivina(String nuevoAdivina) {
		this.adivina = nuevoAdivina;
	}
	
	public void setCantidadPistas(int nuevaCantPistas) {
		this.cantPistas = nuevaCantPistas;
	}
	
	public void setNivel(int nuevoNivel) {
		this.nivel = nuevoNivel;
	}
}

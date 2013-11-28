
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JuegoTEST {

	Juego juego;
	
	@Before
	public void setUp() {
		juego = new Juego("Pedro");
	}
	
	@Test
	public void verificarletraSiSeEncuentraEnLaPalabra() {
		String letra="e";
		assertEquals(true, juego.verificarLetraEnPalabra(letra));
	}

	@Test
	public void verificarletraNoSeEncuentraEnLaPalabra() {
		String letra="s";
		assertEquals(false, juego.verificarLetraEnPalabra(letra));
	}
	
	@Test
	public void poneNumeroDeErroresDeAcuerdoAlNivel() {
		juego.seleccionarNivel(2);
		assertEquals(4, juego.getCantidadErrores());
	}
	
	@Test
	public void verificaSiJugadorGano() {
		juego.seleccionarNivel(2);
		juego.getAdivina().equals("Pedro");
		assertEquals(1, juego.verificarGanador());
	}
	
	@Test
	public void verificaSiJuegadorPerdio() {
		juego.seleccionarNivel(2);
		juego.setCantidadErrores(4);
		assertEquals(-1, juego.verificarGanador());
	}
	
	@Test
	public void verificaSiElJuegoContinua() {
		juego.seleccionarNivel(2);
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("P _ d r o");
		assertEquals(0, juego.verificarGanador());
	}
	
	@Test
	public void rellenarLetraEnPalabra() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("P _ d r o");
		juego.dibujarLetraEnPalabra("e");
		assertEquals("Pedro", juego.getAdivina());
	}
	
	@Test
	public void poneCasillasEnBlancoPalabra() {
		assertEquals("_ _ _ _ _", juego.dibujarPalabraConCasillasVacias());
	}
	
	/*@Test
	public void rellenarcasillasblanco() {
		prueba.palabra = "hola";
		prueba.poneradivina();
		assertEquals("____", prueba.adivina);
	}*/
	
	@Test
	public void ingresoLetraCorrecta() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("_ _ _ _ _");
		juego.ingresarLetra("P");
		assertEquals("P _ _ _ _", juego.getAdivina());
	}
	
	@Test
	public void ingresoLetraIncorrecta() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("_ _ _ _ _");
		juego.ingresarLetra("w");
		assertEquals("_ _ _ _ _", juego.getAdivina());
		assertEquals(1, juego.getCantidadErrores());
	}
	
	@Test
	public void verificaSiIngresoLetraErronea() throws ClassNotFoundException, IOException {
		juego.getPalabra().equals("Pedro");
		assertEquals(false, juego.ingresarLetra("@"));
	}
	
	@Test
	public void verificarLetraIngresada1() {
		assertEquals(true, juego.verificarLetraCorrecta("h"));
	}
	
	@Test
	public void verificarLetraIngresada2() {
		assertEquals(true, juego.verificarLetraCorrecta("H"));
	}
	
	@Test
	public void verificarLetraIngresada3() {
		assertEquals(false, juego.verificarLetraCorrecta("@"));
	}
	
	@Test
	public void darPista1() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("_ _ _ _ _");
		assertEquals("P", juego.mostrarPista());
	}
	
	@Test
	public void darPista2() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("P _ d r _");
		assertEquals("o", juego.mostrarPista());
	}
	
	@Test
	public void devuelveVacioSiNumeroDePistasExcedeLimite3() {
		juego.getPalabra().equals("Pedro");
		juego.getAdivina().equals("_ _ _ _ _");
		juego.setCantidadPistas(4);
		assertEquals("", juego.mostrarPista());
	}
	
/*
	@Test
	public void seleccionarpalabras() {
		ArrayList<Palabras> nue = new ArrayList<Palabras>();
		ArrayList<Palabras> actu = new ArrayList<Palabras>();
		Palabras pa = new Palabras();
		Palabras pa1 = new Palabras();
		Palabras pa2 = new Palabras();
		pa.categoria = "Otros";
		pa.palabra = "hola";
		pa.dificultad = 1;
		nue.add(pa);
		actu.add(pa);
		pa1.categoria = "Otros";
		pa1.palabra = "alabarda";
		pa1.dificultad = 1;
		nue.add(pa1);
		actu.add(pa1);
		pa2.categoria = "Otros";
		pa2.palabra = "holaasemeun";
		pa2.dificultad = 2;
		nue.add(pa2);
		prueba.lista = nue;
		prueba.obtenerpalabrascriterionivel(1, "Otros");
		assertEquals(actu, prueba.lista);
	}
*/
	/*@Test
	public void sacaraleatorio() {
		ArrayList<Palabras> nue = new ArrayList<Palabras>();
		ArrayList<Palabras> actu = new ArrayList<Palabras>();
		Palabras pa = new Palabras();
		Palabras pa1 = new Palabras();
		pa.categoria = "Otros";
		pa.palabra = "hola";
		pa.dificultad = 1;
		actu.add(pa);
		nue.add(pa);
		pa1.categoria = "Otros";
		pa1.palabra = "alabarda";
		pa1.dificultad = 1;
		nue.add(pa1);
		actu.add(pa1);
		prueba.lista = nue;
		prueba.seleccionarpalabra();
		assertEquals(true, actu.contains(prueba.seleccionado));
	}*/
	
	@Test
	public void dibujarMunhecoNivelFacil() {
		juego.setCantidadErrores(3);
		juego.setNivel(1);
		assertEquals(" " + "O" + "<br>" + "/" + "|", juego.munhecoNivelFacil());
	}
	
	@Test
	public void dibujarMunhecoNivelMedio() {
		juego.setCantidadErrores(3);
		juego.setNivel(2);
		assertEquals(" " + "O" + "<br>" + "/" + "|" + "\\" + "<br>" + "/", juego.munhecoNivelMedio());
	}
	
	@Test
	public void dibujarMunhecoNivelDificil() {
		juego.setCantidadErrores(1);
		juego.setNivel(3);
		assertEquals(" " + "O" + "<br>" + "/" + "|", juego.munhecoNivelDificil());
	}
}


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ComandosJuegoTEST {

	
	ComandosJuego prueba = new ComandosJuego();
	
	@Test
	public void obtenerpalabra() {
		prueba.palabra = "hola";
		assertEquals("hola", prueba.palabra);
	}
	
	@Test
	public void verificarletraSi() {
		String letra="e";
		prueba.palabra="Pedro";
		assertEquals(true, prueba.verificarletra(letra));
	}

	@Test
	public void verificarletraNo() {
		String letra="s";
		prueba.palabra="Pedro";
		assertEquals(false, prueba.verificarletra(letra));
	}
	
	@Test
	public void obtenerpalabradiccionario() throws ClassNotFoundException, IOException {
		prueba.obtenerpalabras();
		assertEquals(false, prueba.lista.isEmpty());
	}
	
	@Test
	public void agregarpalabra() throws ClassNotFoundException, IOException {
		prueba.obtenerpalabras();
		int cant = prueba.lista.size();
		Palabras e = new Palabras();
		e.palabra = "hola";
		e.dificultad = 1;
		e.categoria = "Otros";
		prueba.agregarpalabra(e);
		prueba.obtenerpalabras();
		assertEquals(cant+1, prueba.lista.size());
	}
	
	@Test
	public void seleccionnivel() {
		prueba.seleccionarnivel(2);
		assertEquals(4, prueba.canterrores);
	}
	
	@Test
	public void gano() {
		prueba.seleccionarnivel(2);
		prueba.palabra="hola";
		prueba.adivina = "hola";
		assertEquals(1, prueba.verificarganador());
	}
	
	@Test
	public void perdio() {
		prueba.seleccionarnivel(2);
		prueba.errores = 4;
		assertEquals(-1, prueba.verificarganador());
	}
	
	@Test
	public void continuajuego() {
		prueba.seleccionarnivel(2);
		prueba.palabra="hola";
		prueba.adivina = "h_la";
		assertEquals(0, prueba.verificarganador());
	}
	
	@Test
	public void rellenarpalabra() {
		prueba.palabra="hola";
		prueba.adivina = "h_la";
		prueba.rellenar("o");
		assertEquals("hola", prueba.adivina);
	}
	
	@Test
	public void rellenarcasillasblanco() {
		prueba.palabra = "hola";
		prueba.poneradivina();
		assertEquals("____", prueba.adivina);
	}
	
	@Test
	public void ingresoletracorrecta() {
		prueba.palabra = "hola";
		prueba.adivina = "____";
		prueba.ingresoletra("h");
		assertEquals("h___", prueba.adivina);
	}
	
	@Test
	public void ingresoletraincorrecta() {
		prueba.palabra = "hola";
		prueba.adivina = "____";
		prueba.ingresoletra("w");
		assertEquals("____", prueba.adivina);
		assertEquals(1, prueba.errores);
	}
	
	@Test
	public void ingresoletraerronea() throws ClassNotFoundException, IOException {
		prueba.palabra = "hola";
		assertEquals(false, prueba.ingresoletra("@") );
	}
	
	@Test
	public void veriletra1() {
		assertEquals(true, prueba.letracorrecta("h"));
	}
	
	@Test
	public void veriletra2() {
		assertEquals(true, prueba.letracorrecta("H"));
	}
	
	@Test
	public void veriletra3() {
		assertEquals(false, prueba.letracorrecta("@"));
	}
	
	@Test
	public void darpista1() {
		prueba.palabra = "hola";
		prueba.adivina = "____";
		assertEquals("h", prueba.mostrarpista());
	}
	
	@Test
	public void darpista2() {
		prueba.palabra = "hola";
		prueba.adivina = "h_l_";
		assertEquals("o", prueba.mostrarpista());
	}
	
	@Test
	public void darpista3() {
		prueba.palabra = "hola";
		prueba.adivina = "____";
		prueba.cantpista = 4;
		assertEquals("", prueba.mostrarpista());
	}

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
	
	@Test
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
	}
	
	@Test
	public void dibujarfacil() {
		prueba.errores = 3;
		prueba.nivel = 1;
		assertEquals(" " + "O" + "<br>" + "/" + "|", prueba.dibujarmunheco());
	}
	
	@Test
	public void dibujarnormal() {
		prueba.errores = 3;
		prueba.nivel = 2;
		assertEquals(" " + "O" + "<br>" + "/" + "|" + "\\" + "<br>" + "/", prueba.dibujarmunheco());
	}
	@Test
	public void dibujardificil() {
		prueba.errores = 1;
		prueba.nivel = 3;
		assertEquals(" " + "O" + "<br>" + "/" + "|", prueba.dibujarmunheco());
	}
}

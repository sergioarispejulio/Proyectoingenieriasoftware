
import static org.junit.Assert.*;

import java.io.IOException;

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

}

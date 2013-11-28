import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PalabraTEST {

	Palabra palabra;
	
	@Before
	public void setUp()
	{
		palabra = new Palabra("hola");
	}
	
	@Test
	public void obtenerPalabra() {
		assertEquals("hola", palabra.getPalabra());
	}
	
	@Test
	public void cambiarPalabra()
	{
		palabra.setPalabra("adios");
		assertEquals("adios", palabra.getPalabra());
	}
	
	@Test
	public void dibujarEspaciosEnPalabra()
	{
		assertEquals("_ _ _ _ ", palabra.dibujarPalabraConEspacios());
	}
}

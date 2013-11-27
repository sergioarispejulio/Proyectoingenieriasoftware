import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class DiccionarioTEST {

	Diccionario dic = new Diccionario();
	
	@Test
	public void obtengoPalabrasSiDiccionarioNoEstaVacio() throws ClassNotFoundException, IOException
	{
		dic.obtenerPalabrasDeDiccionario();
		assertEquals(false, dic.getDiccionario().isEmpty());
	}

	@Test
	public void agregaPalabrasAlDiccionario() throws ClassNotFoundException, IOException
	{
		dic.obtenerPalabrasDeDiccionario();
		Palabra palabra = new Palabra();
		int cant = dic.getDiccionario().size();
		palabra.setPalabra("hola");
		palabra.setDificultad(1);
		palabra.setCategoria("Otros");
		dic.agregarPalabraADicionario(palabra);
		dic.obtenerPalabrasDeDiccionario();
		assertEquals(cant+1, dic.getDiccionario().size());
	}
	
}

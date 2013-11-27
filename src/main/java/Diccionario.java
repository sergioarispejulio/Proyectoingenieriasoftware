import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Diccionario {
	private ArrayList<Palabra> diccionario;
	
	public Diccionario()
	{
		this.diccionario = new ArrayList<Palabra>();
	}
	
	public ArrayList<Palabra> getDiccionario()
	{
		return diccionario;
	}
	
	public final void obtenerPalabrasDeDiccionario() throws IOException, ClassNotFoundException
	{
		diccionario.clear();
		try
		{
			FileInputStream fileIn = new FileInputStream("diccionario.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			while(fileIn.available() > 0)
			{
				Palabra aux = new Palabra();
				aux = (Palabra) in.readObject();
				diccionario.add(aux);
			}
			in.close();
			fileIn.close();
			diccionario.remove(null);
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return;
		}
	}
	
	public final void obtenerPalabrasSegunNivelCategoria(int nivel, String categoria)
	{
		Palabra aux = new Palabra();
		for(int i=0; i<	diccionario.size(); i++)
		{
			aux = diccionario.get(i);
			if(aux.getDificultad() == nivel && aux.getCategoria().equals(categoria))
			{
				diccionario.add(aux);
			}
		}
	}
	
	public final void agregarPalabraADicionario(Palabra palabra)
	{
		palabra.getPalabra().equals(palabra.getPalabra().toLowerCase());
		diccionario.add(palabra);
		try
		{
			FileOutputStream fileOut = new FileOutputStream("diccionario.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			while(diccionario.isEmpty() == false)
			{
				Palabra auxPalabra = diccionario.get(0);
				System.out.printf(auxPalabra.getPalabra());
				out.writeObject(auxPalabra);
				diccionario.remove(0);
			}
			out.close();
			fileOut.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
}

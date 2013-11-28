
public class Palabra implements java.io.Serializable
{
	private String palabra;
	private int dificultad;
	private String frase;
	private String categoria;
	
	public Palabra()
	{
		this.palabra = "";
		this.dificultad = -1;
		this.frase = "";
		this.categoria = "";
	}
	
	public Palabra(String palabra)
	{
		this.palabra = palabra;
		this.dificultad = -1;
		this.frase = "";
		this.categoria = "";
	}
	
	public String dibujarPalabraConEspacios()
	{
		String palabraAdivina = "";
		for(int i=0; i<this.palabra.length(); i++)
		{
			palabraAdivina += "_"+" ";
		}
		return palabraAdivina;
	}

	// GETS
	
	public String getPalabra()
	{
		return palabra;
	}
	
	public String getFrase()
	{
		return frase;
	}
	
	public int getDificultad()
	{
		return dificultad;
	}
	
	// SETS
	
	public String getCategoria()
	{
		return categoria;
	}
	
	public void setPalabra(String nuevaPalabra)
	{
		this.palabra = nuevaPalabra;
	}
	
	public void setFrase(String nuevaFrase)
	{
		this.frase = nuevaFrase;
	}
	
	public void setDificultad(int nuevaDificultad)
	{
		this.dificultad = nuevaDificultad;
	}
	
	public void setCategoria(String nuevaCategoria)
	{
		this.categoria = nuevaCategoria;
	}
}

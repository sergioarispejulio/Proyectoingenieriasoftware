import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TablapuntageServet extends HttpServlet {

	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<Usuario> lista = null;
		
		
		try {
			ArrayList<Usuario> listamedioasc = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 2, true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ArrayList<Usuario> listamediodes = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 2, false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<Usuario> listadificilasc = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 3, true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ArrayList<Usuario> listadificildes = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 3, false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
			out.println("<center>Lista de puntages altos</center><br><br>");
			
			out.println("Nivel facil ascendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 1, true);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("Nivel facil descendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 1, false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("Nivel medio ascendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 2, true);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("Nivel medio descendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 2, false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("Nivel dificil ascendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 3, true);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("Nivel dificil descendente<br>");
			out.println("<table><tr>");
			out.println("<td>Nombre</td><td>Puntage</td></tr>");
			try {
				lista = singleton.devolverordenadonivel(singleton.obtenerusuarios(), 3, false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			while(lista.isEmpty() == false)
			{
				out.println("<tr><td>"+lista.get(0).nombre+"</td><td>"+lista.get(0).puntagefacil+"</td></tr>");
				lista.remove(0);
			}
			out.println("</table><br>");
			
			out.println("<a href=IndexUsuarioServlet>Salir</a>");
			
		out.println("</body>");
		out.println("</html>");

	}
	
}

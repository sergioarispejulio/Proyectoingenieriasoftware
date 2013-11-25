import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TerminarServlet extends HttpServlet  {

	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton(); 
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
			out.println("Termino el juego, tu puntage es "+singleton.tot+"<br>");
			if(singleton.actual != null)
			{
				Usuario anti = singleton.actual;
				switch (singleton.nivel) {
				case 1:
					singleton.actual.puntagefacil = singleton.tot;
					break;
					
				case 2:
					singleton.actual.puntagemedio = singleton.tot;
					break;
					
				case 3:
					singleton.actual.puntagedificil = singleton.tot;
					break;
				}
				try {
					singleton.actualizarusuario(singleton.actual, anti);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				out.println("<a href=IndexUsuarioServlet>Volver al inicio</a>");
			}
			else
			{
				out.println("<a href=index.html>Volver al inicio</a>");
			}
		out.println("</body>");
		out.println("</html>");
	}
	
}

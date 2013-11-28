
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexUsuarioServlet extends HttpServlet{

	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
				out.println("</head>");
		out.println("<body>");
			out.println("<h1>BIENVENIDO AL JUEGO AHORCADO</h1> <br><br><br>");
			out.println("<Center>");
			out.println("<h2>Escoja el nivel que quiere jugar : </h2>");
			out.println("<Form action=facil.html name=nivelFacil>");
	        out.println("<input type=submit id=facil value=Facil> Puntage mas alto: "+singleton.actual.puntagefacil);
	        out.println("</Form>");
	        out.println("<Form action=normal.html name=nivelNormal>");
	        out.println("<input type=submit id=facil value=Normal> Puntage mas alto: "+singleton.actual.puntagemedio);
	        out.println("</Form>");
	        out.println("<Form action=dificil.html name=nivelDificil>");
	        out.println("<input type=submit id=facil value=Dificil>Puntage mas alto: "+singleton.actual.puntagedificil);
	        out.println("</Form>");
	        
	        out.println("<Form action=TablapuntageServet >");
	        out.println("<input type=submit id=facil value=VerPuntagesGenerales>");
	        out.println("</Form>");
	        
	        out.println("<Form action=EditarServlet>");
	        out.println("<input type=submit id=facil value=Editartusdatos>");
	        out.println("</Form>");
	        
	        out.println("</Center>");
	        out.println("<a href=LogoffServlet>Salir</a>");
		out.println("</body>");
		out.println("</html>");

	}

}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AhorcadoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ComandosJuego ahorcado = new ComandosJuego();
		ahorcado.obtenerpalabras();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<br>");
		response.getWriter().println(ahorcado.obtenerUnaPalabraVacia(0));
		out.println("<br>");
		out.println("<br>");
		response.getWriter().println(
				"Cantidad de errores: " + ahorcado.canterrores);
		out.println("<br>");
		out.println("<br>");
		out.println("<Form action='AhorcadoServlet'>");
		out.println("<Input type=text>");
		out.println("<Input type=submit>");
		out.println("</Form>");

		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		// while (ahorcado.verificarganador() != -1
		// || ahorcado.verificarganador() != 1) {
		// response.getWriter().println("<Form action='AhorcadoServlet'><input type=text id=letra><input type=submit id=submit></Form>");

		// }
	}
}
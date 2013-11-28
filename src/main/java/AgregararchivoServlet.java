
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgregararchivoServlet extends HttpServlet {
	Palabra nuevo = new Palabra();
	Juego juego = new Juego();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		nuevo.palabra = request.getParameter("pala");
		nuevo.dificultad = Integer.parseInt(request.getParameter("difi"));
		nuevo.categoria = request.getParameter("cate");
		try {
			juego.obtenerpalabras();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		juego.agregarpalabra(nuevo);
		out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv=Refresh content=0;url=Administrador.html>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");

	}
}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AhorcadoServlet extends HttpServlet {

	ComandosJuego juego = new ComandosJuego();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("nivel") != null)
		{
			juego.seleccionarnivel(Integer.parseInt(request.getParameter("nivel")));
			try {
				juego.obtenerpalabras();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			juego.palabra = "maria";
			juego.adivina = "_____";
		}
		if(request.getParameter("letra") != null)
		{
			juego.ingresoletra(request.getParameter("letra"));
		}
		out.println("<html>");
		
		out.println("<head>");
			if(juego.verificarganador() == -1)
			{
				out.println("<meta http-equiv=Refresh content=0;url=perder.html>");
			}
			if(juego.verificarganador() == 1)
			{
				out.println("<meta http-equiv=Refresh content=0;url=ganar.html>");
			}
		out.println("</head>");
		
		out.println("<body>");
			out.println("<center>");
			out.println("<br>");
			response.getWriter().println(juego.adivina);
			out.println("<br>");
			out.println("<br>");
			response.getWriter().println(
					"Cantidad de errores: " + juego.errores + " de " + juego.canterrores);
			out.println("<br>");
			out.println("<br>");
			
			out.println("<Form action='AhorcadoServlet'>");
			out.println("<Input type=text name=letra maxlength=1>");
			out.println("<Input type=submit>");
			out.println("</Form>");
			
			out.println("<br>");
			out.println("Cantidad de pistas disponibles: "+(3-juego.cantpista)+"<br>");
			if(juego.cantpista < 3)
			{
				out.println("<Form action='AhorcadoServlet'>");
				out.println("<Input type=hidden name=pista>");
				out.println("<Input type=submit value=Ayuda>");
				out.println("</Form>");
			}
			
			if(request.getParameter("pista") != null)
			{
				out.println("<br>");
				out.println("Ayuda: "+ juego.mostrarpista());
			}
			out.println("<br><br>");
			for(int i =0; i < juego.lista.size(); i++)
			{
				out.println(juego.lista.get(i).palabra+"-"+juego.lista.get(i).dificultad+"-"+juego.lista.get(i).categoria+"/n");
			}
			out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}
}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AhorcadoServlet extends HttpServlet {

	ComandosJuego juego = new ComandosJuego();
	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton(); 
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean prueba=false;
		if(request.getParameter("nivel") != null)
		{
			juego.seleccionarnivel(Integer.parseInt(request.getParameter("nivel")));
			try {
				juego.obtenerpalabras();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			juego.obtenerpalabrascriterionivel(Integer.parseInt(request.getParameter("nivel")) , request.getParameter("cate"));
			if(juego.lista.isEmpty() == false)
			{
				juego.seleccionarpalabra();
				juego.poneradivina();
				juego.errores = 0;
				juego.cantpista = 0;
				juego.puntage = 0;
			}
			else
			{
				juego.puntage = 0;
				prueba = true;
			}
		}
		if(request.getParameter("letra") != null)
		{
			juego.ingresoletra(request.getParameter("letra"));
		}
		out.println("<html>");
		
		out.println("<head>");
			if(prueba == false)
			{
				if(juego.verificarganador() == 1)
				{
					if(juego.lista.isEmpty() == false)
					{
						juego.seleccionarpalabra();
						juego.poneradivina();
						juego.errores = 0;
						juego.cantpista = 0;
					}
					else
					{
						singleton.nivel = juego.nivel;
						singleton.tot = juego.puntage;
						out.println("<meta http-equiv=Refresh content=0;url=TerminarServlet>");
					}
				}
				if(juego.verificarganador() == -1)
				{
					singleton.tot = juego.puntage;
					singleton.nivel = juego.nivel;
					out.println("<meta http-equiv=Refresh content=0;url=TerminarServlet>");
				}
			}
			else
			{
				singleton.tot = juego.puntage;
				singleton.nivel = juego.nivel;
				out.println("<meta http-equiv=Refresh content=0;url=TerminarServlet>");
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
			out.println("Puntage: "+juego.puntage);
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
			if(singleton.actual != null)
			{
				out.println("<a href=IndexUsuarioServlet>Volver al inicio</a>");
			}
			else
			{
				out.println("<a href=index.html>Volver al inicio</a>");
			}
			out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
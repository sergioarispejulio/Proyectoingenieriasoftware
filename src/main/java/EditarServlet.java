import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarServlet extends HttpServlet {

ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
	        
	        out.println("<form action=ReemplazarServlet>");
	        out.println("Usuario: <input type=text name=usu value="+singleton.actual.login+"><br>");
	        out.println("Password: <input type=password name=pass><br>");
	        out.println("Pais: ");
	        out.println("<select name=ciu>");
	        	out.println("<option value=Bolivia>Bolivia</option>");
	        	out.println("<option value=Argentina>Argentina</option>");
	        	out.println("<option value=Chile>Chile</option>");
	        out.println("</select><br>");
	        out.println("Ci: <input type=number max=1000000 min=1 name=ci value="+singleton.actual.ci+"><br>");
	        out.println("Nombre: <input type=text name=nombre value="+singleton.actual.nombre+"><br>");
	        out.println("<input type=submit>");
	        out.println("</form>");
	        out.println("<a href=IndexUsuarioServlet>Volver</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
}

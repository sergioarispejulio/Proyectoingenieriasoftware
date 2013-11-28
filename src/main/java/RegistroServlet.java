import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistroServlet extends HttpServlet {

	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton();
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Usuario nue = new Usuario();
		if(request.getParameter("admi") != null)
		{
			nue.admi = true;
		}
		else
		{
			nue.admi = false;
		}
		nue.ci = Integer.parseInt(request.getParameter("ci"));
		nue.nombre = request.getParameter("nombre");
		nue.login = request.getParameter("usu");
		nue.pass = request.getParameter("pass");
		nue.pais = request.getParameter("ciu");
		nue.puntagedificil = 0;
		nue.puntagefacil = 0;
		nue.puntagemedio = 0;
		try {
			singleton.registrar(nue);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv=Refresh content=0;url=index.html>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");

	}
	
}

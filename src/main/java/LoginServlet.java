
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{

	ComandosUsuarioSingleton singleton = ComandosUsuarioSingleton.getSingleton();
	boolean exito;
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Usuario re = new Usuario();
		re.login = request.getParameter("usu");
		re.pass = request.getParameter("pass");
		try {
			exito = singleton.verificarlogin(re);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(exito);
		out.println("<html>");
		out.println("<head>");
		if(exito == true)
		{
			System.out.println("CORRECTO - "+singleton.actual.admi);
			if(singleton.actual.admi == true)
			{
				out.println("<meta http-equiv=Refresh content=0;url=Administrador.html>");
			}
			else
			{
				out.println("<meta http-equiv=Refresh content=0;url=IndexUsuarioServlet>");
			}
		}
		else
		{
			System.out.println("ERRONEO");
			out.println("<meta http-equiv=Refresh content=0;url=index.html>");
		}
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
	}
	
}

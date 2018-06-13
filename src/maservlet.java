

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;

import org.joda.time.DateTime;

/**
 * Servlet implementation class maservlet
 */
@WebServlet("/maservlet")
public class maservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public maservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Protocole : " + request.getProtocol());
		out.println("Adresse IP du client : " + request.getRemoteAddr());
		out.println("Nom du client : " + request.getLocalName());
		out.println("Nom du serveur : " + request.getServerName());
		out.println("Port du server : " + request.getServerPort());
		out.println("Schema : " + request.getScheme());
		for(Enumeration<String> elem = request.getParameterNames(); elem.hasMoreElements();) {
			String key = elem.nextElement();
			out.println(key + " : " + request.getParameter(key));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/traitement")
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Affichage dans une page pseudo HTML
		// PrintWriter out = response.getWriter();
		// out.println("Demande prise en compte.");
		for(Enumeration<String> elem = request.getParameterNames(); elem.hasMoreElements();) {
			String key = elem.nextElement();
			// TODO traitement possible : on pourrait imaginer envoyer ces données à mysql
			// à la place de la BDD, affichage dans la console du serveur
			System.out.println(key + " : " + request.getParameter(key));
			// Le out qui affiche dans la page rendu au client
			// out.println(key + " : " + request.getParameter(key));
		}
		request.getRequestDispatcher("vue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

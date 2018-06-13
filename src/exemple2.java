

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exemple2
 */
@WebServlet("/exemple2")
public class exemple2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exemple2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()
			.append(request.getProtocol())
			.append("\n")
			.append(request.getRemoteAddr())
			.append("\n")
			.append(request.getMethod())
			.append("\n")
			.append("Client : ")
			.append(request.getRemoteUser())
			.append("\n")
			.append(request.getServerName())
			.append("\n")
			.append(Integer.toString(request.getServerPort()))
			.append("\n")
			.append(request.getScheme());
		response.getWriter().append("TEST");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

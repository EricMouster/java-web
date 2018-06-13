package person;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDao dao = new PersonDao();
		List<Person> persons = dao.findAll();
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("person.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonDao dao = new PersonDao();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		if (!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && id.isEmpty()) {
			Person person = new Person();
			person.setFirstName(firstname);
			person.setLastName(lastname);
			person.setEmail(email);
			dao.insert(person);
		} else if (!id.isEmpty()) {
			Person person = dao.findById(Integer.parseInt(id));
			person.setFirstName(firstname);
			person.setLastName(lastname);
			person.setEmail(email);
			dao.update(person);
		} else {
			request.setAttribute("error", "true");
		}
		doGet(request, response);
	}

}

package boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.bookstore_query;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default Constructor
     */
    public RemoveFromCartServlet() {
        super();
    }

	/**
	 * Go here first
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("param");
		int quantity = Integer.parseInt(request.getParameter("param2"));
		System.out.println("ISBN is : " + isbn);
		HttpSession session = request.getSession();
		bookstore_query query = new bookstore_query();
		query.removeBookFromCart(session.getAttribute("email").toString(), isbn, quantity);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/DisplayCartServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartItem;
@WebServlet("/ShoppingCartRemover")
public class ShoppingCartRemover extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShoppingCartRemover() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
		
	List<CartItem> lista = (List<CartItem>) session.getAttribute("lista");
	lista = removeFromList(lista, request);
	request.getRequestDispatcher("zakupy.jsp").forward(request, response);
	}
	public List<CartItem> removeFromList(List<CartItem> lista, HttpServletRequest request) {
		
		List<CartItem> kopia = lista;
		Iterator iter= kopia.iterator();
		String toRemove = request.getParameter("whatToRemove");
		CartItem ItemToRemove= new CartItem();
		while (iter.hasNext()) {
			CartItem fromList = (CartItem) iter.next();
			if (fromList.getProd().getName().equals(toRemove)){
			ItemToRemove= fromList;
			}
			}
		System.out.println("udane usunięcie z koszyka " + toRemove);
		lista.remove(ItemToRemove);
		return lista;			
		
	}
}

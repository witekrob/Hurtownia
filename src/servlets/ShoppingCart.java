package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ProductDao;
import model.CartItem;
import model.Product;

@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private List<CartItem> shoppingList = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public ShoppingCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesja = request.getSession(true);
		List<CartItem> lista = createList(request);
		sesja.setAttribute("lista", lista);
		int overallPrice = (int) sesja.getAttribute("overallPrice");
		sesja.setAttribute("overallPrice", overallPrice);
		request.getRequestDispatcher("zakupy.jsp").forward(request, response);
	}

	private List<CartItem> createList(HttpServletRequest request) {

		String productName = request.getParameter("ProductName");
		int quantity = Math.abs(Integer.parseInt(request.getParameter("Quantity")));
		ProductDao prodDao = new ProductDao();
		Product prod = new Product();
		List<Product> lista = prodDao.get1byName(productName);
		Iterator<Product> iter = lista.iterator();
		if (iter.hasNext()) {
			prod = iter.next();
		}
		int newquantity = (prod.getQuantity() - quantity);
		prod.setQuantity(newquantity);
		prodDao.updateQuantity(productName, newquantity);
		CartItem item = new CartItem(prod, quantity);

		shoppingList.add(item);
		return shoppingList;
	}
	private List<CartItem> removeFromList(List<CartItem> lista, HttpServletRequest request) {
		Iterator iter= lista.iterator();
		String toRemove = request.getParameter("whatToRemove");
		CartItem ItemToRemove= new CartItem();
		while (iter.hasNext()) {
			ItemToRemove = (CartItem) iter.next();
			if (ItemToRemove.getProd().getName().equals(toRemove)){
				lista.remove(ItemToRemove);
			}
		}
		
		return lista;			
		
	}
}

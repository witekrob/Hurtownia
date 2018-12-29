package servlets;

import model.Product;
import controller.ProductDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/productsServlet")
public class productsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public productsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String aaa = request.getParameter("choice");
		String producer = request.getParameter("producer");
		int price = 0;
		int quantity = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
		} catch (NumberFormatException nfe) {
		}

		String choice = request.getParameter("choice");

		ProductDao proDao = new ProductDao();

		if ("getAll".equals(choice)) {
			System.out.println(choice);
			List<Product> productsList = new ArrayList<Product>();
			productsList = proDao.getAll();
			System.out.println(productsList);
			request.setAttribute("productsList", productsList);
			request.getRequestDispatcher("/getProducts.jsp").forward(request, response);

		} else if ("addProduct".equals(choice)) {
			Product prod = new Product();
			prod.setName(name);
			prod.setProducer(producer);
			prod.setPrice(price);
			prod.setQuantity(quantity);

			String actionResult = null;
			int result = proDao.addProduct(prod);
			if (result == 1) {
				actionResult = "Pomyślnie dodano produkt";
			} else {
				actionResult = "Nie udane dodanie produktu";
			}
			request.setAttribute("product", prod);
			request.setAttribute("actionResult", actionResult);
			request.getRequestDispatcher("addingResult.jsp").forward(request, response);
		} else if ("search".equals(choice)) {
			List<Product> productList = new ArrayList<Product>();
			String findingMethod = null;
			findingMethod = request.getParameter("findingMethod");
			System.out.println(findingMethod);
			if ("byProducer".equals(findingMethod)) {
				productList = proDao.get1byProducer(producer);
				request.setAttribute("productsList", productList);
				request.getRequestDispatcher("/getProducts.jsp").forward(request, response);
			} else if ("byName".equals(findingMethod)) {
				productList = proDao.get1byName(name);
				System.out.println(productList.toString());
				request.setAttribute("productsList", productList);
				request.getRequestDispatcher("/getProducts.jsp").forward(request, response);

			}
		}

	}

}

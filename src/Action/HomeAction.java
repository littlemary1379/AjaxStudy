package Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import repository.Repository;


public class HomeAction implements Action{
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Repository repository=new Repository();
		List<Product> products=repository.orderbyId();
		
		System.out.println(products);
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	
		
	}

}

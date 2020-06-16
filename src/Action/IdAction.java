package Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Product;
import repository.Repository;
import util.Script;


public class IdAction implements Action{
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Repository repository=new Repository();
		List<Product> products=repository.orderbyId();
		
		System.out.println(products);
		request.setAttribute("products", products);
		
		Gson gson=new Gson();
		String productJson=gson.toJson(products);
		Script.outJson(productJson, response);
	
		
	}

}

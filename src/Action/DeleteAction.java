package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.Repository;


public class DeleteAction implements Action{
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println(id);
		int parseId=Integer.parseInt(id);
		Repository repository=new Repository();
		int result=repository.deletebyId(parseId);
		PrintWriter out=response.getWriter();
		out.print(result);

	
		
	}

}

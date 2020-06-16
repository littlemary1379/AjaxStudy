package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.CountAction;
import Action.DeleteAction;
import Action.HomeAction;
import Action.IdAction;
import Action.PriceAction;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/cont")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "Controller : ";
    
	public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println(TAG+"cmd : "+cmd);
		Action action=router(cmd);
		action.execute(response,request);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("home")) {
			return new HomeAction(); //홈페이지 액션
		}else if(cmd.equals("price")) {
			return new PriceAction(); //가격 정렬
		}else if(cmd.equals("count")) {
			return new CountAction(); //판매수 정렬
		}else if(cmd.equals("id")) {
			return new IdAction(); //아이디(처음) 정렬
		}else if(cmd.equals("delete")) {
			return new DeleteAction(); //삭제 프로세스
		}
		return null;
		
	}

}

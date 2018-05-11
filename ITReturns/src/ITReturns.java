

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITReturns
 */
@WebServlet("/ITReturns")
public class ITReturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITReturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= req.getParameter("nam");
		String gend=req.getParameter("gen");
		String sala=req.getParameter("sal");
		String taxd=req.getParameter("tax");
		
		PrintWriter pw=resp.getWriter();
		PrintWriter fw= new PrintWriter("out.txt");
		pw.println("SUCCESSFULL!");
		fw.println("Name : "+name);
		fw.println("Gender : "+gend);
		fw.println("Salary : "+sala);
		fw.println("Tax : "+taxd);
		fw.close();
		
	}

}

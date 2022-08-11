package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProprietarioDao;


/**
 * Servlet implementation class ProprietarioDelete
 */
@WebServlet("/ProprietarioDelete")
public class ProprietarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProprietarioDao proprietarioDao = new ProprietarioDao();
		int id = Integer.parseInt(request.getParameter("id"));
		proprietarioDao.delete(id);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	

}

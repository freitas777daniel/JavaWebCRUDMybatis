package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VeiculoDao;

/**
 * Servlet implementation class VeiculoDelete
 */
@WebServlet("/VeiculoDelete")
public class VeiculoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VeiculoDao veiculoDao = new VeiculoDao();
		int id = Integer.parseInt(request.getParameter("id"));
		veiculoDao.delete(id);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

package ar.com.nec.blockbuster.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.nec.blockbuster.entities.Cliente;
import ar.com.nec.blockbuster.entities.Genero;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import ar.com.nec.blockbuster.entities.Pelicula;
import ar.com.nec.blockbuster.Connection;

/**
 * Servlet implementation class Alquiler
 */
@WebServlet("/Alquiler")
public class Alquiler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alquiler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pelicula = null;
		String action = request.getParameter("action");
		if("get".equals(action)) {

			//pelicula = new Pelicula("batman","bla");
		}
		JSONObject json = new JSONObject();
		if(pelicula!=null) {
			json.put("nombre", pelicula.getNombre());
			json.put("genero", pelicula.getGenero());
		}
		response.getWriter().append(json.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

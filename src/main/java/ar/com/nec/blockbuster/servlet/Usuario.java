package ar.com.nec.blockbuster.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import ar.com.nec.blockbuster.Connection;
import ar.com.nec.blockbuster.entities.Genero;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import ar.com.nec.blockbuster.entities.Cliente;
import ar.com.nec.blockbuster.entities.Pelicula;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cliente usuario = null;
		String action = request.getParameter("action");
		if("create".equals(action)) {

			String nombre=request.getParameter("nombre");
			int dni=Integer.parseInt(request.getParameter("dni"));
			usuario = new Cliente(nombre,dni);
			
		}
		JSONObject json = new JSONObject();
		if(usuario!=null) {
			json.put("nombre", usuario.getNombre());
			json.put("dni", usuario.getDni());
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

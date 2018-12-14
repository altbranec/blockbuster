package ar.com.nec.blockbuster.servlet;

import ar.com.nec.blockbuster.Connection;
import ar.com.nec.blockbuster.entities.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


        String action = request.getParameter("action");
        if("create".equals(action)) {

            Session sessionObj;
            Transaction tx;
            Cliente cliente = null;
            try {
                sessionObj= Connection.session().openSession();
                tx = sessionObj.beginTransaction();
                cliente = new Cliente(request.getParameter("nombre"),Integer.parseInt(request.getParameter("dni")));
                sessionObj.save(cliente);
                tx.commit();
                if(cliente!=null) {
                    response.getWriter().append("Creado correctamente");
                }


            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
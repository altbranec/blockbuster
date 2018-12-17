package ar.com.nec.blockbuster.servlet;

import ar.com.nec.blockbuster.Connection;
import ar.com.nec.blockbuster.entities.Cliente;
import ar.com.nec.blockbuster.entities.Pelicula;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        Session sessionObj;
        Transaction tx;

        if ("create".equals(action)) {

            Pelicula peli = null;
            try {
                sessionObj = Connection.session().openSession();
                tx = sessionObj.beginTransaction();
                peli = new Pelicula(request.getParameter("nombre"), request.getParameter("genero"));
                sessionObj.save(peli);
                tx.commit();
                if (peli != null) {
                    response.getWriter().append("Creado correctamente");
                }


            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }

        }

        if ("delete".equals(action)) {
            Pelicula peli;
            try {
                sessionObj = Connection.session().openSession();
                tx = sessionObj.beginTransaction();
                peli = new Pelicula(request.getParameter("nombre"), request.getParameter("genero"));
                sessionObj.delete(peli);
                tx.commit();

            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
        if ("showCatalog".equals(action)) {

            sessionObj = Connection.session().openSession();
            Query query = sessionObj.createQuery("FROM Pelicula");
            ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) query.list();


        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

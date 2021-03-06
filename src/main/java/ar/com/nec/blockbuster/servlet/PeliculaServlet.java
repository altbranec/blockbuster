package ar.com.nec.blockbuster.servlet;

import ar.com.nec.blockbuster.Connection;
import ar.com.nec.blockbuster.entities.Genero;
import ar.com.nec.blockbuster.entities.Pelicula;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
            Genero genero = null;
            try {
                sessionObj = Connection.sessionFactory().openSession();
                tx = sessionObj.beginTransaction();
               // Query query = sessionObj.createQuery("FROM Genero");
                List<Genero> generos = Connection.elementosDeClase(Genero.class);
                if(generos.stream().filter(o -> o.getNombre().equals(request.getParameter("genero"))).findFirst().isPresent()){
                    peli = new Pelicula(request.getParameter("nombre"), generos.stream().filter(o -> o.getNombre().equals(request.getParameter("genero"))).findFirst().get());
                }else{
                    genero = new Genero(request.getParameter("genero"));
                    sessionObj.save(genero);
                    peli = new Pelicula(request.getParameter("nombre"), genero);
                }
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
                sessionObj = Connection.sessionFactory().openSession();
                tx = sessionObj.beginTransaction();
               // Query query = sessionObj.createQuery("FROM Pelicula");
                List<Pelicula> peliculas = Connection.elementosDeClase(Pelicula.class);;
                if(peliculas.stream().filter(o -> o.getNombre().equals(request.getParameter("nombre"))).findFirst().isPresent()){
                    sessionObj.delete(peliculas.stream().filter(o -> o.getNombre().equals(request.getParameter("nombre"))).findFirst().get());
                    tx.commit();
                }else{
                    response.getWriter().append("No existe la pelicula");
                }

            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
        if ("showCatalog".equals(action)) {

           // sessionObj = Connection.sessionFactory().openSession();
            List<Pelicula> peliculas = Connection.elementosDeClase(Pelicula.class);;
            //Query query = sessionObj.createQuery("FROM Pelicula");
            //ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) query.list();


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

package ar.com.nec.blockbuster;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ar.com.nec.blockbuster.entities.*;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

/*	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;*/

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		Session sessionObj;
		Transaction tx = null;
		List<Genero> generos = new ArrayList<>();
		try {
			sessionObj= Connection.session().openSession();
			/*Genero genero = sessionObj.byNaturalId(Genero.class)
					.using("nombre",request.getParameter("action"))
					.load();*/

			Cliente pepe = new Cliente("pepe",123);
			Genero accion = new Genero("accion");
			Pelicula batman = new Pelicula("Batman",accion);
			Pelicula superman = new Pelicula("Superman",accion);
			sessionObj.save(accion);
			sessionObj.save(batman);
			sessionObj.save(superman);
			pepe.addAlquiler(batman);
			pepe.addAlquiler(superman);
			sessionObj.save(pepe);
			sessionObj.getTransaction().commit();

		} catch(Exception sqlException) {

			sqlException.printStackTrace();
		}


	}

}

package ar.com.nec.blockbuster;

import ar.com.nec.blockbuster.entities.Genero;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.criterion.*;

import java.util.List;


public class Connection {
    static SessionFactory sessionFactoryObj = null;
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
    public static SessionFactory session(){
        if(sessionFactoryObj == null){
            return buildSessionFactory();
        }else{ return sessionFactoryObj;}
    }
    public static Genero findGeneroByNombre(String nombreGenero) {
        Criteria criteria = session().openSession().createCriteria(Genero.class);
        return (Genero) criteria.add(Restrictions.eq("nombre", nombreGenero)).uniqueResult();
    }
}

package ar.com.nec.blockbuster;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
    public static SessionFactory sessionFactory(){
        if(sessionFactoryObj == null){
            return buildSessionFactory();
        }else{ return sessionFactoryObj;}
    }
    public static <T> List<T> elementosDeClase(Class<T> type) {
        Session sessionObj = sessionFactory().openSession();
        CriteriaQuery<T> criteriaQuery = sessionObj.getCriteriaBuilder().createQuery(type);
        criteriaQuery.from(type);
        List<T> data = sessionObj.createQuery(criteriaQuery).getResultList();
        sessionObj.close();
        return data;
    }
}

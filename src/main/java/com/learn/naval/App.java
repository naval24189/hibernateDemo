package com.learn.naval;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.security.auth.login.AppConfigurationEntry;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        User user=new User();

        user.setId(98973);
        user.setName("fgdf");
        user.setPlace("fgd");



        Configuration con=new Configuration().configure().addAnnotatedClass(User.class);


        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        session.save(user);

        tx.commit();




        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
         session=factory.openSession();

        //Hibernate Named Query
        TypedQuery query = session.getNamedQuery("findUserByName");
        //query.setParameter("name","amit");

        List<User> u_list=query.getResultList();


        for(User u:u_list)
            System.out.println(u.getName()+"  "+u.getPlace()+u.getId());


    }
}

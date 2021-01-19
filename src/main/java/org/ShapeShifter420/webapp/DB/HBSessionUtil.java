package org.ShapeShifter420.webapp.DB;

import org.ShapeShifter420.webapp.DB.models.Menu;
import org.ShapeShifter420.webapp.DB.models.Tables;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.util.Properties;

@PropertySource(value = {"classpath:application.properties"})
public class HBSessionUtil {
    private static SessionFactory sessionFactory;

    public HBSessionUtil() {
    }

    public static SessionFactory getSessionFactory() {
            try {
                //FileInputStream fileInputStream = new FileInputStream("application.properties");
                //Properties property = new Properties();
                //property.load(fileInputStream);
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Menu.class);
                configuration.addAnnotatedClass(Tables.class);
                //System.out.println(name + password);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                //fileInputStream.close();

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        return sessionFactory;
    }
}
